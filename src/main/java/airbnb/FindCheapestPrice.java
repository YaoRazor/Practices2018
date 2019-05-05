package airbnb;

import java.util.*;

// 这一题因为有K这个限制在，所以用BFS比较合适
public class FindCheapestPrice {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();

        for(int[] flight: flights) {
            if(!prices.containsKey(flight[0])) {
                prices.put(flight[0], new HashMap<>());
            }
            prices.get(flight[0]).put(flight[1], flight[2]);
        }

        // 对于此数组，第一个number存的是当前的stop, 第二个存的是从src到现在这个站的距离
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{src, 0});
        int ans = Integer.MAX_VALUE;
        int steps = 0;

        while(!deque.isEmpty()) {

            if(steps>k+1) {
                break;
            }

            int size = deque.size();

            for(int i=0; i<size; i++) {

                int[] cur = deque.pop();
                if(cur[0]==dst) {
                    ans = Math.min(ans, cur[1]);
                }

                if(!prices.containsKey(cur[0])) {
                    continue;
                }

                for(Integer next: prices.get(cur[0]).keySet()) {
                    int cost = prices.get(cur[0]).get(next);

                    if(cur[1]+cost>ans) {
                        continue;
                    } else {
                        deque.addLast(new int[]{next, cur[1]+cost});
                    }
                }

            }

            steps++;
        }

        return ans==Integer.MAX_VALUE? -1: ans;

    }
}
