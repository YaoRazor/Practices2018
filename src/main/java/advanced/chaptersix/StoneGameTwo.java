package advanced.chaptersix;

public class StoneGameTwo {

    // TC: O(n)
    public int stoneGame2(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }

        int n = nums.length;
        int m = n*2;

        int[] A = new int[m];
        for(int i=0; i<m; i++) {
            A[i] = nums[i%n];
        }

        int[][] dp = new int[m][m];
        int[] preSum = new int[m+1];
        preSum[0] = 0;
        for(int i=0; i<m; i++) {
            // dp[i][j] represents the minimum score needed to merge the stones,
            // therefore dp[i][i] should be initialized as zero
            dp[i][i] = 0;
            preSum[i+1] = preSum[i]+A[i];
        }

        for(int length=2; length<=n; length++) {
            for(int i=0; i+length-1<m; i++) {
                dp[i][i+length-1] = Integer.MAX_VALUE;
                for(int j=i; j<i+length-1; j++) {
                    dp[i][i+length-1] = Math.min(dp[i][i+length-1], dp[i][j]+dp[j+1][i+length-1]+preSum[i+length]-preSum[i]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            ans = Math.min(dp[i][i+n-1], ans);
        }

        return ans;
    }

}
