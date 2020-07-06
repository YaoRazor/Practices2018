package advanced.chaptersix.optional;

public class BackPackIV {
    public int backPackIV(int[] nums, int target) {
        if(nums==null || nums.length==0) {
            return 0;
        }

        int n = nums.length;

        int[][] dp = new int[n+1][target+1];

        for(int i=1; i<=target; i++) {
            dp[0][i] = 0;
        }

        dp[0][0] = 1;

        for(int i=1; i<=n; i++) {
            dp[i][0] = 1;
            for(int j=1; j<=target; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=nums[i-1]) {
                    dp[i][j]+=dp[i][j-nums[i-1]];
                }
            }
        }

        return dp[n][target];
    }
}
