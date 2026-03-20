package dp;

import java.util.*;

public class longestCommonSubsquence {
    private int[][] t;

    public int LCS(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return t[m][n] = 0;

        if (t[m][n] != -1)
            return t[m][n];

        if (s1.charAt(m ) == s2.charAt(n))
            return t[m][n] = 1 + LCS(s1, s2, m - 1, n - 1);

        return t[m][n] = Math.max(LCS(s1, s2, m, n - 1), LCS(s1, s2, m - 1, n));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        t = new int[m + 1][n + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return LCS(text1, text2, m, n);
    }

    //recurssion based
    public int longestCommonSubsequence2(String s1, String s2 ){
        int m = s1.length();
        int n = s2.length();
        return lcs2(s1,s2,m,n);
    }

    public int lcs2(String s1, String s2,int m , int n ){
        if(n == 0 || m == 0) return 0;
        if(s1.charAt(n) == s2.charAt(m)){
            return 1+lcs2(s1,s2,m-1, n-1);
        }
        return Math.max(lcs2(s1,s2,m-1,n) , lcs2(s1,s2,m,n-1));

        //Time Complexity = O(2^(m+n)

    }


}
