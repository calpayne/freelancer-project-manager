package projectmanager.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import projectmanager.MessageAlert;
import projectmanager.ProjectManager;
import projectmanager.models.Project;
import projectmanager.models.ProjectLog;
import projectmanager.models.ProjectSort;

/**
 *
 * @author Cal Payne
 */
public class ProjectViewDialog extends JDialog {

    public ProjectViewDialog(Project project) {
        super(ProjectManager.app, "Viewing: " + project.getName(), true);
        GridBagConstraints c = new GridBagConstraints();
        String[] titles = {"Client Name: ", "Client Email: ", "Start Date: ", "Deadline: ", "Price: ", "Priority: ",
            "Progress: "};
        String[] data = {project.getClientName(), project.getClientEmail(), project.getStartDate().toString(),
            project.getDeadline().toString(), project.getFormattedPrice(),
            project.getPriority().toString().replaceAll("_", " "),
            Integer.toString(project.getProgress()) + "% complete"};

        JPanel leftContainer = new JPanel();
        leftContainer.setLayout(new GridBagLayout());

        int row = 0;
        c.insets = new Insets(5, 5, 5, 5);
        for (int i = 0; i < titles.length; i++) {
            c.gridx = 0;
            c.gridy = row;
            c.anchor = GridBagConstraints.WEST;
            leftContainer.add(new JLabel(titles[i]), c);

            c.gridx = 1;
            c.anchor = GridBagConstraints.EAST;
            leftContainer.add(new JLabel(data[i]), c);

            row++;
        }

        JTextArea notes = new JTextArea(project.getNotes(), 11, 24);
        notes.setLineWrap(true);
        notes.setEditable(false);

        JButton delete = new JButton("Delete");
        delete.addActionListener((ActionEvent ae) -> {
            if (MessageAlert.confirmChoice("Are you sure you want to delete project " + project.getName() + "?")) {
                ProjectLog.getInstance().removeProject(project);

                MainPanel.getInstance().updateView(ProjectSort.DEFAULT);

                MessageAlert.showMessage("Project deleted!");

                this.dispose();
            }
        });

        this.setLayout(new FlowLayout());
        this.add(leftContainer);
        this.add(notes);
        this.add(delete);
        this.setBackground(Color.decode("#F5F5F5"));
        this.setResizable(false);
        this.setSize(new Dimension(600, 260));
        this.setLocationRelativeTo(ProjectManager.app);
        this.setVisible(true);
    }

}
