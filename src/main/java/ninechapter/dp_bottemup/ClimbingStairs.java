package ninechapter.dp_bottemup;


public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n<=0) {
            return 0;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // Take a look at how to solve this problem
    // using rolling array, but do not spend too
    // much time on this
    public int climbStairsRollingArray(int n) {
        if(n<=0) {
            return 0;
        }

        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i%3] = dp[(i-1)%3] + dp[(i-2)%3];
        }

        return dp[n%3];
    }


}
