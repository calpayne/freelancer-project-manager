package projectmanager.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;
import projectmanager.InputValidation;
import projectmanager.MessageAlert;
import projectmanager.ProjectManager;
import projectmanager.models.Priority;
import projectmanager.models.Project;
import projectmanager.models.ProjectLog;
import projectmanager.models.ProjectSort;

/**
 *
 * @author Cal Payne
 */
public class ProjectDialog extends JDialog {

    public ProjectDialog(Project project, boolean isEditMode, String title) {
        super(ProjectManager.app, title, true);

        GridBagConstraints c = new GridBagConstraints();
        String[] titles = {"Name: ", "Client Name: ", "Client Email: ", "Price: ", "Progress: "};
        JTextField[] input = new JTextField[titles.length];

        JPanel leftContainer = new JPanel();
        leftContainer.setLayout(new GridBagLayout());
        JPanel rightContainer = new JPanel();
        rightContainer.setLayout(new GridBagLayout());

        int row = 0;
        int loop = isEditMode ? titles.length : titles.length - 1;

        c.insets = new Insets(8, 8, 8, 8);
        for (int i = 0; i < loop; i++) {
            c.gridx = 0;
            c.gridy = row;
            c.anchor = GridBagConstraints.WEST;
            leftContainer.add(new JLabel(titles[i]), c);

            c.gridx = 1;
            c.anchor = GridBagConstraints.EAST;

            if (isEditMode) {
                String[] preload = {project.getName(), project.getClientName(), project.getClientEmail(),
                    Double.toString(project.getPrice()), Integer.toString(project.getProgress())};
                input[i] = new JTextField(preload[i]);
            } else {
                input[i] = new JTextField();
            }

            input[i].setColumns(18);
            leftContainer.add(input[i], c);

            row++;
        }

        c.gridx = 0;
        c.gridy = row;
        c.anchor = GridBagConstraints.WEST;
        leftContainer.add(new JLabel("Priority: "), c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.EAST;
        JComboBox priority = new JComboBox(Priority.values());
        priority.setPreferredSize(new Dimension(202, 20));
        if (isEditMode) {
            priority.setSelectedItem(project.getPriority());
        }
        leftContainer.add(priority, c);

        Properties properties = new Properties();
        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");
        UtilDateModel startDate = new UtilDateModel();
        if (isEditMode) {
            startDate.setValue(project.getStartDate());
        } else {
            startDate.setValue(new Date());
        }
        JDatePanelImpl startDatePanel = new JDatePanelImpl(startDate, properties);

        c.gridx = 0;
        c.gridy = row + 1;
        c.anchor = GridBagConstraints.WEST;
        leftContainer.add(new JLabel("Start Date: "), c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.EAST;
        leftContainer.add(startDatePanel, c);

        UtilDateModel deadline = new UtilDateModel();
        if (isEditMode) {
            deadline.setValue(project.getDeadline());
        } else {
            deadline.setValue(new Date());
        }
        JDatePanelImpl deadlinePanel = new JDatePanelImpl(deadline, properties);

        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        rightContainer.add(new JLabel("Deadline: "), c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.EAST;
        rightContainer.add(deadlinePanel, c);

        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        rightContainer.add(new JLabel("Notes: "), c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.EAST;
        JTextArea notes = new JTextArea(10, 18);
        if (isEditMode) {
            notes.setRows(13);
            notes.setText(project.getNotes());
        }
        notes.setLineWrap(true);
        rightContainer.add(notes, c);

        JButton submit = new JButton("Add the Project");
        if (isEditMode) {
            submit.setText("Save your Edit");
        }
        submit.addActionListener((ActionEvent ae) -> {

            if (isEditMode) {
                editProject(project, input[0].getText(), input[1].getText(), input[2].getText(), input[3].getText(),
                        (Priority) priority.getSelectedItem(), startDate.getValue(), deadline.getValue(),
                        notes.getText(), input[4].getText());
            } else {
                addProject(input[0].getText(), input[1].getText(), input[2].getText(), input[3].getText(),
                        (Priority) priority.getSelectedItem(), startDate.getValue(), deadline.getValue(),
                        notes.getText());
            }

        });

        this.setLayout(new FlowLayout());
        this.add(leftContainer);
        this.add(rightContainer);
        this.add(submit);
        this.setBackground(Color.decode("#F5F5F5"));

        if (isEditMode) {
            this.setSize(new Dimension(675, 495));
        } else {
            this.setSize(new Dimension(675, 455));
        }

        this.setLocationRelativeTo(ProjectManager.app);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void editProject(Project project, String name, String clientName, String clientEmail, String price,
            Priority priority, Date startDate, Date deadline, String notes, String progress) {
        if (InputValidation.validateProject(name, clientName, clientEmail, price, startDate, deadline, progress)) {
            project.setName(name);
            project.setClientName(clientName);
            project.setClientEmail(clientEmail);
            project.setNotes(notes);
            project.setStartDate(startDate);
            project.setDeadline(deadline);
            project.setPrice(Double.parseDouble(price));
            project.setPriority(priority);
            project.setProgress(Integer.parseInt(progress));

            MainPanel.getInstance().updateView(ProjectSort.DEFAULT);

            MessageAlert.showMessage("Your edit has been saved!");

            this.dispose();
        }
    }

    private void addProject(String name, String clientName, String clientEmail, String price, Priority priority,
            Date startDate, Date deadline, String notes) {
        if (InputValidation.validateProject(name, clientName, clientEmail, price, startDate, deadline, "1")) {
            ProjectLog.getInstance().addProject(new Project(name, clientName, clientEmail, notes, startDate, deadline,
                    Double.parseDouble(price), priority, 1));

            MainPanel.getInstance().updateView(ProjectSort.DEFAULT);

            MessageAlert.showMessage("Project added!");

            this.dispose();
        }
    }

}
