package projectmanager;

import java.util.Date;

/**
 *
 * @author Cal Payne
 */
public class InputValidation {

    public static boolean textLength(int min, int max, String s) {
        return s != null && s.length() <= max && s.length() >= min;
    }

    public static boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        try {
            double n = Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean numberSize(int min, int max, int n) {
        return n <= max && n >= min;
    }

    public static boolean validateProject(String name, String clientName, String clientEmail, String price,
            Date startDate, Date deadline, String progress) {
        boolean r = true;
        if (!InputValidation.textLength(3, 15, name)) {
            MessageAlert.showError("Please enter a name that is 3 to 15 letters long.");
            r = false;
        } else if (!InputValidation.textLength(3, 25, clientName)) {
            MessageAlert.showError("Please enter a client name that is 3 to 25 letters long.");
            r = false;
        } else if (!InputValidation.textLength(3, 25, clientEmail)) {
            MessageAlert.showError("Please enter a client email that is 3 to 25 letters long.");
            r = false;
        } else if (!InputValidation.isNumber(price)) {
            MessageAlert.showError("Please enter a valid number for the price.");
            r = false;
        } else if (startDate == null) {
            MessageAlert.showError("Please select a date for the start date.");
            r = false;
        } else if (deadline == null) {
            MessageAlert.showError("Please select a date for the deadline.");
            r = false;
        } else if (startDate.after(deadline)) {
            MessageAlert.showError("Your start date is after the deadline.");
            r = false;
        } else if (!InputValidation.isNumber(progress) || Integer.parseInt(progress) < 1
                || Integer.parseInt(progress) > 100) {
            MessageAlert.showError("Please enter a valid number between 1 and 100 for the progress.");
            r = false;
        }

        return r;
    }

}
