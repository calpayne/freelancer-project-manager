package projectmanager;

import javax.swing.JOptionPane;

/**
 *
 * @author Cal Payne
 */
public class MessageAlert {

    public static void showError(String message) {
        JOptionPane.showMessageDialog(ProjectManager.app, message, "Error, something is wrong",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(ProjectManager.app, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirmChoice(String message) {
        boolean r = false;
        int choice = JOptionPane.showConfirmDialog(null, message, "Confirm your choice", JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            r = true;
        }
        return r;
    }

}
