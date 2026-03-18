package dp;

public class climbStrairs {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int[] dp = new int[n+1];
        dp[1] =1;
        dp[2] =2;

        for(int i = 3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];

    }

    /*
    for stairs 4

    1,1,1,1
    2,2
    2,1,1
    1,2,1
    1,1,2


    Without DP, we recompute the same steps multiple times. By storing results of smaller steps (like 2, 3, 4),
     we reuse them and reduce time complexity

     */
}
