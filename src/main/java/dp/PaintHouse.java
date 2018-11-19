package dp;

public class PaintHouse {

    // 如果当前Paint green, 那么就找之前Paint red和yellow的最小值加上当前paint green的cost
    public int minCost(int[][] costs) {

        if(costs==null || costs.length==0) {
            return 0;
        }

        int[] dp = new int[3];

        dp[0] = costs[0][0];
        dp[1] = costs[0][1];
        dp[2] = costs[0][2];

        for(int i=1; i<costs.length; i++) {
            int tmp0 = dp[0];
            int tmp1 = dp[1];
            int tmp2 = dp[2];
            dp[0] = Math.min(tmp1, tmp2) + costs[i][0];
            dp[1] = Math.min(tmp0, tmp2) + costs[i][1];
            dp[2] = Math.min(tmp1, tmp0) + costs[i][2];

        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));

    }
}
