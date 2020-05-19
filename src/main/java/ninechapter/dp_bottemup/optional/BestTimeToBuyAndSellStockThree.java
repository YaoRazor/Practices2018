package ninechapter.dp_bottemup.optional;


public class BestTimeToBuyAndSellStockThree {

    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2) {
            return 0;
        }

        int n = prices.length;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 0;
        int profit = 0;
        int low = prices[0];

        // From left to right to calculate the best transaction ending on this index
        for(int i=1; i<n; i++) {
            profit = Math.max(prices[i]-low, profit);
            left[i] = profit;
            low = Math.min(prices[i], low);
        }

        right[n-1] = 0;
        int high = prices[n-1];
        profit = 0;

        // From right to left to calculate the best transaction starting from this index to end
        for(int i=n-2; i>=0; i--) {
            profit = Math.max(high-prices[i], profit);
            right[i] = profit;
            high = Math.max(prices[i], high);
        }

        profit = 0;

        // Complete two transactions
        for(int i=1; i<n; i++) {
            profit = Math.max(profit, left[i-1]+right[i]);
        }

        // Complete one transaction
        for(int i=0; i<n; i++) {
            profit = Math.max(profit, left[i]);
        }

        return profit;
    }
}
