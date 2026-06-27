package dp;

import java.util.Arrays;

public class deleteOperationsOfStrings {

    int l1 ,l2;

    public int minDistance(String word1, String word2) {
        l1 = word1.length();
        l2 = word2.length();

        int[][] dp = new int[l1][l2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }


        return solve(word1, word2, 0 , 0,dp);

    }

    public int solve(String word1, String word2 , int i , int j , int[][] dp){

        if(i>=l1 && j>= l2) return 0;

        if(i>=l1) return l2-j;

        if(j>=l2) return l1-i;

        if(dp[i][j]  != -1){
            return dp[i][j];
        }


        if(word1.charAt(i) != word2.charAt(j)){
            dp[i][j] =  1+ Math.min(solve(word1,word2, i+1,j,dp), solve(word1, word2, i,j+1,dp));
        }else{
            dp[i][j] = solve(word1, word2,i+1,j+1,dp);
        }

        return dp[i][j];

    }
}
