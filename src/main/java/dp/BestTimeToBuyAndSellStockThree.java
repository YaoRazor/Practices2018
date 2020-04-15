package dp;

// See https://www.cnblogs.com/grandyang/p/4281975.html
public class BestTimeToBuyAndSellStockThree {

    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0 ) {
            return 0;
        }

        int n = prices.length;

        int[][] l = new int[n][3];
        int[][] g = new int[n][3];

        for(int i=1; i<n; i++) {
            int diff = prices[i]-prices[i-1];

            for(int j=1; j<=2; j++) {
                l[i][j] = Math.max(g[i-1][j-1], l[i-1][j])+diff;
                g[i][j] = Math.max(l[i][j], g[i-1][j]);
            }


        }

        return g[n-1][2];
    }
}
