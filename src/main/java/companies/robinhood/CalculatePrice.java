package companies.robinhood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatePrice {

    class Result {
        int max;
        int min;
        Result(final int max, final int min) {
            this.max = max;
            this.min = min;
        }

        @Override
        public String toString() {
            return "max is: "+this.max+" min is "+this.min;
        }
    }

    public List<Result> calculate(int[][] prices) {
        List<Result> ans = new ArrayList<>();
        Map<Integer, Result> map = new HashMap<>();

        Arrays.sort(prices, (p1, p2)-> p1[1]-p1[1]);

        for(int[] price: prices) {
            int window = price[1]/10;
            if(map.containsKey(window)) {
                map.get(window).max = Math.max(map.get(window).max, price[0]);
                map.get(window).min = Math.min(map.get(window).min, price[0]);
            } else {
                map.put(window, new Result(price[0], price[0]));
            }
        }

        Result pre = new Result(Integer.MAX_VALUE, Integer.MIN_VALUE);
        int maxWindow = prices[prices.length-1][1]/10;
        System.out.println("Max Window is "+maxWindow);

        for(int i=0; i<=maxWindow; i++) {
            if(map.containsKey(i)) {
                ans.add(map.get(i));
                pre = map.get(i);
            } else {
                ans.add(pre);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        CalculatePrice calculatePrice = new CalculatePrice();
        int[][] input = {{10, 1}, {23, 3}, {15, 10}, {18, 17}, {32, 43}, {34, 87}};
        System.out.println(calculatePrice.calculate(input));

        List<Result> ans = calculatePrice.calculate(input);
        for(int i=0; i<ans.size(); i++) {
            System.out.println("Window is "+ i*10+" to "+(i+1)*10);
            System.out.println("Result is "+ans.get(i));
        }

    }
}
