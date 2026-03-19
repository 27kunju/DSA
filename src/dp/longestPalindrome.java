package dp;

import java.util.Arrays;

public class longestPalindrome {

    private int[][] t;

    public String LongestPalindrome(String s) {
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

    private boolean solve(String s, int l, int r) {
        if (l >= r) {
            return true;
        }

        if (t[l][r] != -1) {
            return t[l][r] == 1;
        }

        if (s.charAt(l) == s.charAt(r)) {
            t[l][r] = solve(s, l + 1, r - 1) ? 1 : 0;
        } else {
            t[l][r] = 0;
        }

        return t[l][r] == 1;
    }

    public String longestPalindrome2(String s) {
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int start = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j) && (j - i + 1) > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    private boolean isPalindrome(String s, int l, int r) {
        //When l >= r, it means we have compared all characters successfully, so the substring is a palindrome.”
        if (l >= r) return true;

        if (s.charAt(l) != s.charAt(r)) return false;

        return isPalindrome(s, l + 1, r - 1);
    }
}
