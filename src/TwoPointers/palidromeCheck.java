package TwoPointers;

public class palidromeCheck {
    public static void main(String[] args) {
        String s = "race#car rac$ecar";
        System.out.println(palindromeChecker(s));
    }
    public static  boolean palindromeChecker(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            // Skip non-alphanumeric characters
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (r > l  && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            // Compare ignoring case
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }

        return true;

    }

    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }
}
