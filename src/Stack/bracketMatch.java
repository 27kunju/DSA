package Stack;

public class bracketMatch {
    static int bracketMatch(String text) {

        int open = 0;
        int unmatchedClose = 0;

        for (char ch : text.toCharArray()) {

            if (ch == '(') {
                open++;
            } else { // ')'
                if (open > 0) {
                    open--; // match
                } else {
                    unmatchedClose++; // extra ')'
                }
            }
        }

        return open + unmatchedClose;
    }

    public static void main(String[] args) {
        String text = "(()";
        System.out.println(bracketMatch(text)); // Output: 1
    }
}
