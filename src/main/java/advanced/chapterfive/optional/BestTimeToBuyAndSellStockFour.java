package advanced.chapterfive.optional;

public class BestTimeToBuyAndSellStockFour {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54113/A-Concise-DP-Solution-in-Java
    public int maxProfit(int K, int[] prices) {
        if(prices==null || prices.length==0) {
            return 0;
        }

        int n = prices.length;
        if(K>=n/2) {
            return quickSolve(prices);
        }

        int[][] dp = new int[K+1][n];

        for(int i=1; i<=K; i++) {
            int tmpMax = - prices[0];
            for(int j=1; j<n; j++) {
                dp[i][j] = Math.max(dp[i][j-1], prices[j]+tmpMax);
                tmpMax = Math.max(dp[i-1][j-1]-prices[j], tmpMax);
            }
        }

        return dp[K][n-1];
    }


    private int quickSolve(int[] prices) {
        int ans = 0;
        for(int i=1; i<prices.length; i++) {
            ans+=Math.max(0, prices[i]-prices[i-1]);
        }

        return ans;
    }
}
