package advanced.chapterfive;

public class BurstBalloons {

    // TC: O(n^3). SC: O(N^2)
    public int maxCoins(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }

        int n = nums.length;

        int[] newNums = new int[n+2];
        newNums[0] = newNums[n+1] = 1;

        for(int i=1; i<=n; i++) {
            newNums[i] = nums[i-1];
        }

        n+=2;

        // dp[i][j] meaning the maxcore to
        // burst ballons between i and j but
        // not including i and j. This is the key point
        int[][] dp = new int[n][n];

        for(int i=0; i<n-1; i++) {
            dp[i][i+1] = 0;
        }

        for(int len=3; len<=n; len++) {
            for(int i=0; i+len<=n; i++) {
                int j = i+len-1;
                for(int k=i+1; k<j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k]+dp[k][j]+newNums[i]*newNums[j]*newNums[k]);
                }
            }

        }

        return dp[0][n-1];
    }
}
