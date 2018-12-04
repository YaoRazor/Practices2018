package bfs;

import java.util.*;

// Dijkstra算法介绍, https://blog.csdn.net/qq_35644234/article/details/60870719
public class FindCheapestPrice {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();

        for(int[] flight: flights) {

            if(!prices.containsKey(flight[0])) {
                prices.put(flight[0], new HashMap<>());
            }

            prices.get(flight[0]).put(flight[1], flight[2]);

        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        // 用Visited来防止pop出已经记录过的节点
        Set<Integer> visited = new HashSet<>();

        pq.add(new int[]{0, src, k+1});

        while(!pq.isEmpty()) {

            // 每次pop出来都是Dijkstra的新的当前节点，也就是最新确定的距离最小的节点，这里必须要pop, 不能top
            int[] top = pq.poll();
            int price = top[0];
            int city = top[1];
            int stops = top[2];

            visited.add(city);

            if(city==dst) {
                return price;
            }

            //这个stops是用来满足题目要求的在k个中转站之内完成飞行的条件
            if(stops>0) {

                Map<Integer, Integer> map = prices.getOrDefault(city, new HashMap<>());

                for(int neighbor: map.keySet()) {

                    // 用当前节点的出边来更新其相邻的节点的距离，其实对于同一个neighbor,
                    // 在当前堆里可能已经存了好多个，但是不影响, 因为minHeap只会Pop最小的值
                    if(!visited.contains(neighbor)) {
                        pq.add(new int[]{price+map.get(neighbor), neighbor, stops-1});
                    }
                }

            }

        }

        return -1;

    }
}
