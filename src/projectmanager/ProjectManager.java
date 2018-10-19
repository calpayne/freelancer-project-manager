package projectmanager;

import java.awt.Dimension;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import projectmanager.models.Priority;
import projectmanager.models.Project;
import projectmanager.models.ProjectLog;
import projectmanager.views.MainPanel;

/**
 *
 * @author Cal Payne
 */
public class ProjectManager {

    public static JFrame app;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        addTestData();
        JScrollPane wrap = new JScrollPane(MainPanel.getInstance());
        wrap.getVerticalScrollBar().setUnitIncrement(10);

        app = new JFrame("Project Manager");
        app.setJMenuBar(new TopMenu());
        app.add(wrap);
        app.setSize(new Dimension(615, 500));
        app.setLocationRelativeTo(null);
        app.setResizable(false);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    /**
     *
     * Adding test data (projects)
     *
     */
    public static void addTestData() {
        ProjectLog pl = ProjectLog.getInstance();
        Date d = new Date();
        d.setTime(d.getTime() + 1000000000);

        pl.addProject(new Project("Project 1", "Client Name", "client@email.com", "This is a fun project!",
                new Date(), d, 100, Priority.LOW, 50));
        pl.addProject(new Project("Project 2", "Client Name", "client@email.com", "", new Date(), d, 150,
                Priority.MEDIUM, 10));
        pl.addProject(new Project("Project 3", "Client Name", "client@email.com", "", new Date(), d, 400,
                Priority.VERY_HIGH, 80));
        pl.addProject(new Project("Project 4", "Client Name", "client@email.com", "", new Date(), new Date(),
                300, Priority.LOW, 5));
        pl.addProject(new Project("Project 5", "Client Name", "client@email.com", "", new Date(), d, 50,
                Priority.LOW, 40));
        pl.addProject(new Project("Project 6", "Client Name", "client@email.com", "", new Date(), d, 1000,
                Priority.HIGH, 1));
        pl.addProject(new Project("Project 7", "Client Name", "client@email.com", "", new Date(), d, 200,
                Priority.LOW, 75));
        pl.addProject(new Project("Project 8", "Client Name", "client@email.com", "", new Date(), d, 600,
                Priority.HIGH, 80));
        pl.addProject(new Project("Project 9", "Client Name", "client@email.com", "", new Date(), d, 100,
                Priority.LOW, 1));
        pl.addProject(new Project("Project 10", "Client Name", "client@email.com", "", new Date(), new Date(), 400,
                Priority.VERY_HIGH, 80));
    }

}
