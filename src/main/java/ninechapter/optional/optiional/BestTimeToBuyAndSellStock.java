package ninechapter.optional.optiional;


// The key point is to maintain a min value of previous array
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2) {
            return 0;
        }

        int low = prices[0];
        int profit = 0;

        for(int price: prices) {
            profit = Math.max(price-low, profit);
            low = Math.min(low, price);
        }

        return profit;
    }
}
