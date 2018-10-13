package projectmanager.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Cal Payne
 */
public class ProjectLog {

    private static ProjectLog instance;
    private final ArrayList<Project> log;
    private int length;

    private ProjectLog() {
        log = new ArrayList();
        length = 0;
    }

    /**
     * @return the instance of ProjectLog
     */
    public static ProjectLog getInstance() {
        if (instance == null) {
            instance = new ProjectLog();
        }

        return instance;
    }

    /**
     * @param sortBy how the list should be sorted
     * @return ArrayList of projects
     */
    public ArrayList<Project> getProjects(ProjectSort sortBy) {
        ArrayList<Project> temp = new ArrayList();
        log.forEach((p) -> {
            temp.add(p);
        });

        switch (sortBy) {
            case BY_PRICE:
                temp.sort(Comparator.comparing(Project::getPrice));
                Collections.reverse(temp);
                break;
            case BY_PRIORITY:
                temp.sort(Comparator.comparing(Project::getPriority));
                Collections.reverse(temp);
                break;
            case BY_DEADLINE:
                temp.sort(Comparator.comparing(Project::getDeadline));
                break;
        }

        return temp;
    }

    /**
     * @return the amount of projects
     */
    public int getLength() {
        return this.length;
    }

    /**
     * @param project the project to add
     */
    public void addProject(Project project) {
        log.add(project);
        length++;
    }

    /**
     * @param project the project to remove
     */
    public void removeProject(Project project) {
        log.remove(project);
        length--;
    }

}
