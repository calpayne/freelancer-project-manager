package projectmanager.views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import projectmanager.models.Project;
import projectmanager.models.ProjectLog;
import projectmanager.models.ProjectSort;

/**
 *
 * @author Cal Payne
 */
public class MainPanel extends JPanel {
    
    private static MainPanel instance;
    
    private MainPanel() {
        this.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        int col = 0;
        int row = 0;
        
        for (Project p : ProjectLog.getInstance().getProjects(ProjectSort.DEFAULT)) {
            c.gridx = col;
            c.gridy = row;
            c.insets = new Insets(10, 10, 10, 10);
            this.add(new ProjectBriefPanel(p), c);
            col++;
            
            if(col == 3) {
                col = 0;
                row++;
            }
        }
        
        this.setBackground(Color.decode("#F5F5F5"));
    }
    
    public static MainPanel getInstance() {
        if(instance == null) {
            instance = new MainPanel();
        }
        
        return instance;
    }
    
}
