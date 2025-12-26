package backtracking;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis22 {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n, new StringBuilder());
        return result;
    }

    private void backtrack(int open, int close, int n, StringBuilder sb) {

        // base case
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        // add '(' if possible
        if (open < n) {
            sb.append('(');
            backtrack(open + 1, close, n, sb);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }

        // add ')' if valid
        if (close < open) {
            sb.append(')');
            backtrack(open, close + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
    }
}
