package projectmanager;

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

}
