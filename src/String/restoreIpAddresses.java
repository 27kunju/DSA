package String;

import java.util.*;


public class restoreIpAddresses {
    int n;
    List<String> result = new ArrayList<>();

    private boolean isValid(String str) {
        // cannot have leading zero unless single digit
        if (str.charAt(0) == '0') return str.length() == 1;

        int val = Integer.parseInt(str);
        return val <= 255;
    }

    private void solve(String s, int idx, int part, String curr) {
        // If we used all characters AND we made 4 parts
        if (idx == n && part == 4) {
            result.add(curr.substring(0, curr.length() - 1)); // remove last dot
            return;
        }

        // If parts already exceed 4 or idx beyond string length → invalid
        if (part >= 4 || idx >= n) return;

        // 1-digit part
        if (idx + 1 <= n) {
            solve(s, idx + 1, part + 1, curr + s.substring(idx, idx + 1) + ".");
        }

        // 2-digit part
        if (idx + 2 <= n) {
            String two = s.substring(idx, idx + 2);
            if (isValid(two)) {
                solve(s, idx + 2, part + 1, curr + two + ".");
            }
        }

        // 3-digit part
        if (idx + 3 <= n) {
            String three = s.substring(idx, idx + 3);
            if (isValid(three)) {
                solve(s, idx + 3, part + 1, curr + three + ".");
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        result.clear();
        n = s.length();

        // At most 12 characters for valid 4 parts (3 digits × 4)
        if (n > 12) return result;

        solve(s, 0, 0, "");
        return result;
    }
}
