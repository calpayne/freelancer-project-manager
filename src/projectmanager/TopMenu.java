package projectmanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import projectmanager.models.ProjectSort;
import projectmanager.views.MainPanel;
import projectmanager.views.ProjectDialog;

/**
 *
 * @author Cal Payne
 */
public class TopMenu extends JMenuBar {

    public TopMenu() {
        MenuListener ml = new MenuListener();
        JMenu projectLog = new JMenu("Project Log");
        JMenu project = new JMenu("Project");
        JMenu sort = new JMenu("Sort By");
        JMenu statistics = new JMenu("Statistics");

        JMenuItem newFile = new JMenuItem("New Project Log");
        newFile.setActionCommand("New");
        newFile.addActionListener(ml);
        projectLog.add(newFile);

        JMenuItem openFile = new JMenuItem("Open Project Log");
        openFile.setActionCommand("Open");
        openFile.addActionListener(ml);
        projectLog.add(openFile);

        JMenuItem saveFile = new JMenuItem("Save Project Log");
        saveFile.setActionCommand("Save");
        saveFile.addActionListener(ml);
        projectLog.add(saveFile);

        JMenuItem about = new JMenuItem("About");
        about.setActionCommand("About");
        about.addActionListener(ml);
        projectLog.add(about);

        JMenuItem exitProgram = new JMenuItem("Exit");
        exitProgram.setActionCommand("exit");
        exitProgram.addActionListener(ml);
        projectLog.add(exitProgram);

        JMenuItem newProject = new JMenuItem("Add Project");
        newProject.setActionCommand("addProject");
        newProject.addActionListener(ml);
        project.add(newProject);

        JMenuItem defaultSort = new JMenuItem("Default");
        defaultSort.setActionCommand("defaultSort");
        defaultSort.addActionListener(ml);
        sort.add(defaultSort);

        JMenuItem priceSort = new JMenuItem("Price");
        priceSort.setActionCommand("priceSort");
        priceSort.addActionListener(ml);
        sort.add(priceSort);

        JMenuItem prioritySort = new JMenuItem("Priority");
        prioritySort.setActionCommand("prioritySort");
        prioritySort.addActionListener(ml);
        sort.add(prioritySort);

        JMenuItem deadlineSort = new JMenuItem("Deadline");
        deadlineSort.setActionCommand("deadlineSort");
        deadlineSort.addActionListener(ml);
        sort.add(deadlineSort);

        JMenuItem totalRevenue = new JMenuItem("Total Revenue");
        totalRevenue.setActionCommand("TotalRevenue");
        totalRevenue.addActionListener(ml);
        statistics.add(totalRevenue);

        JMenuItem totalProjects = new JMenuItem("Total Projects");
        totalProjects.setActionCommand("TotalProjects");
        totalProjects.addActionListener(ml);
        statistics.add(totalProjects);

        this.add(projectLog);
        this.add(project);
        this.add(sort);
        this.add(statistics);
    }

    private class MenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            switch (ae.getActionCommand()) {
                case "defaultSort":
                    MainPanel.getInstance().updateView(ProjectSort.DEFAULT);
                    break;
                case "priceSort":
                    MainPanel.getInstance().updateView(ProjectSort.BY_PRICE);
                    break;
                case "prioritySort":
                    MainPanel.getInstance().updateView(ProjectSort.BY_PRIORITY);
                    break;
                case "deadlineSort":
                    MainPanel.getInstance().updateView(ProjectSort.BY_DEADLINE);
                    break;
                case "addProject":
                    ProjectDialog pd = new ProjectDialog(null, false, "Adding a new Project");
                    break;
                case "exit":
                    System.exit(0);
            }

        }

    }

}
