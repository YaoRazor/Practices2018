package bfs;

import java.util.Arrays;


// Two important points here:
// 1. i<=K 因为第一轮算直飞
// 2. Math.min的第一项是tmp

public class FindCheapestPrice {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        int[] prices = new int[n];
        Arrays.fill(prices, 10001);
        prices[src] = 0;

        for(int i=0; i<=K; i++) {

            int[] tmp = Arrays.copyOf(prices, n);

            for(int[] flight: flights) {

                tmp[flight[1]] = Math.min(tmp[flight[1]], prices[flight[0]]+flight[2]);

            }

            prices = tmp;
        }

        return prices[dst]==10001? -1: prices[dst];

    }
}
