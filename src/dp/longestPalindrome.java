package dp;

import java.util.Arrays;

public class longestPalindrome {

    private Boolean[][] dp;

    public String longestPalindrome1(String s) {
        int n = s.length();
        int maxLen = 0;
        int startIndex = 0;

        dp = new Boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (solve(s, i, j)) {
                    if (j - i + 1 > maxLen) {
                        startIndex = i;
                        maxLen = j - i + 1;
                    }
                }
            }
        }

        return s.substring(startIndex, startIndex + maxLen);
    }

    private boolean solve(String s, int l, int r) {
        if (l >= r) return true;

        if (dp[l][r] != null) return dp[l][r];

        if (s.charAt(l) == s.charAt(r)) {
            return dp[l][r] = solve(s, l + 1, r - 1);
        }

        return dp[l][r] = false;
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

    private boolean isPalindrome2(String s, int l ,int r){

        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }

            l++;
            r--;
        }

        return true;

    }
}
