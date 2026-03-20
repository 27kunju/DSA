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

    In Climbing Stairs, we are NOT counting steps,
👉 We are counting number of distinct ways (paths) to reach the top.


    Without DP, we recompute the same steps multiple times. By storing results of smaller steps (like 2, 3, 4),
     we reuse them and reduce time complexity

What Happens If You Use n?
int[] dp = new int[n];

Then indices are:

0 → n-1

👉 You cannot access dp[n] → ArrayIndexOutOfBounds

     */
}
