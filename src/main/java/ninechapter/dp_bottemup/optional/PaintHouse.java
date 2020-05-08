package ninechapter.dp_bottemup.optional;

public class PaintHouse {

    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0) {
            return 0;
        }

        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i=1; i<n; i++) {
            for(int j=0; j<3; j++) {
                dp[i][j] = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + costs[i][j];
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int i=0; i<3; i++) {
            ans = Math.min(ans, dp[n-1][i]);
        }

        return ans;
    }
}
