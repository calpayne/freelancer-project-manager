package projectmanager.views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import projectmanager.models.Project;

/**
 *
 * @author Cal Payne
 */
public class ProjectBriefPanel extends JPanel {
    
    public ProjectBriefPanel(Project project) {
        GridBagConstraints c = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        JProgressBar progress = new JProgressBar(0, 100);
        progress.setValue(project.getProgress());
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(10, 10, 10, 10);
        this.add(new JLabel(project.getName()), c);
        
        c.gridx = 0;
        c.gridy = 1;
        this.add(progress, c);
        
        JButton view = new JButton("View");
        view.addActionListener((ActionEvent ae) -> {
            System.out.println(project.toString());
        });
        
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        this.add(view, c);
        
        JButton edit = new JButton("Edit");
        edit.addActionListener((ActionEvent ae) -> {
            System.out.println("Edit clicked");
        });
        
        c.gridx = 1;
        c.gridy = 2;
        this.add(edit, c);
        
        Color borderColor = Color.GRAY;
        if(project.getDeadline().before(new Date())) {
            borderColor = Color.BLUE;
        }
        
        this.setBackground(Color.decode("#F5F5F5"));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, borderColor));
    }
    
}
