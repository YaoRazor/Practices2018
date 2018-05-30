package array;


// The key point is to maintain a min value of previous array
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // Pay attention to this initial value
        int min = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(prices[i] - min, profit);
            min = Math.min(prices[i], min);
        }

        return profit;
    }
}
