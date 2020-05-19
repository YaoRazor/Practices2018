package ninechapter.dp_bottemup.optional;

public class ClimbStairsTwo {
    // Using rolling array
    public int climbStairs2(int n) {
        int[] dp = new int[4];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<=n; i++) {
            dp[i%4] = dp[(i-1)%4]+dp[(i-2)%4] + dp[(i-3)%4];
        }

        return dp[n%4];
    }
}
