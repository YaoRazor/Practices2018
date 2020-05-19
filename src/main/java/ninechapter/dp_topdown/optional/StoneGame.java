package ninechapter.dp_topdown.optional;

public class StoneGame {
    public int stoneGame(int[] A) {
        if(A==null || A.length==0) {
            return 0;
        }

        int n = A.length;

        int[][] dp = new int[n][n];
        int[] preSum = new int[n+1];
        preSum[0] = 0;
        for(int i=0; i<n; i++) {
            // dp[i][j] represents the minimum score needed to merge the stones,
            // therefore dp[i][i] should be initialized as zero
            dp[i][i] = 0;
            preSum[i+1] = preSum[i]+A[i];
        }

        for(int length=2; length<=n; length++) {
            for(int i=0; i+length-1<n; i++) {
                dp[i][i+length-1] = Integer.MAX_VALUE;
                for(int j=i; j<i+length-1; j++) {
                    dp[i][i+length-1] = Math.min(dp[i][i+length-1], dp[i][j]+dp[j+1][i+length-1]+preSum[i+length]-preSum[i]);
                }
            }
        }

        return dp[0][n-1];
    }
}
