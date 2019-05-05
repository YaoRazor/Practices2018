package array;


// The key point is to maintain a min value of previous array
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1) {
            return 0;
        }

        int maxProfit = 0;
        int curLow = prices[0];

        for(int i=1; i<prices.length; i++) {
            maxProfit =  Math.max(prices[i]-curLow, maxProfit);
            curLow = Math.min(prices[i], curLow);
        }

        return maxProfit;
    }
}
