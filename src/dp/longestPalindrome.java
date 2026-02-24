package dp;

import java.util.Arrays;

public class longestPalindrome {
    public boolean solve(String s, int i, int j) {
        if (i >= j) {
            return true;
        }

        if (s.charAt(i) == s.charAt(j)) {
            return solve(s, i + 1, j - 1);
        }
        return false;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int startPoint = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {   // FIXED
                if (solve(s, i, j)) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        startPoint = i;   // FIXED
                    }
                }
            }
        }

        return s.substring(startPoint, startPoint + maxLen); // FIXED
    }

    private int[][] t;

    public String longestPalindrome2(String s) {
        int n = s.length();
        int maxlen = Integer.MIN_VALUE;
        int startingIndex = 0;
        t = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(t[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (solve(s, i, j) && j - i + 1 > maxlen) {
                    startingIndex = i;
                    maxlen = j - i + 1;
                }
            }
        }

        return s.substring(startingIndex, startingIndex + maxlen);
    }

    private boolean solve2(String s, int l, int r) {
        if (l >= r) {
            return true;
        }

        if (t[l][r] != -1) {
            return t[l][r] == 1;
        }

        if (s.charAt(l) == s.charAt(r)) {
            t[l][r] = solve2(s, l + 1, r - 1) ? 1 : 0;
        } else {
            t[l][r] = 0;
        }

        return t[l][r] == 1;
    }
}
