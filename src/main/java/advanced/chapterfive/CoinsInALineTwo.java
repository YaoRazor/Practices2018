package advanced.chapterfive;

public class CoinsInALineTwo {

    // 看强化班课件
    public boolean firstWillWin(int[] values) {
        if(values==null || values.length<3) {
            return true;
        }

        int n = values.length;

        int[] dp = new int[n];
        dp[n-1] = values[n-1];
        dp[n-2] = values[n-1]+values[n-2];

        for(int i=n-3; i>=0; i--) {
            dp[i] = Math.max(values[i]-dp[i+1], values[i]+values[i+1]-dp[i+2]);
        }

        return dp[0]>=0;
    }
}
