package miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    // Bucket sort: O(N)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer>[] buckets = new List[nums.length+1];

        for(int key: map.keySet()) {
            int cnt = map.get(key);
            if(buckets[cnt]==null) {
                buckets[cnt] = new ArrayList<>();
            }

            buckets[cnt].add(key);
        }

        int[] ans = new int[k];
        for(int i=nums.length; i>=0 && k>0; i--) {
            if(buckets[i]==null) {
                continue;
            }

            for(int j: buckets[i]) {
                ans[--k] = j;
                if(k==0) {
                    break;
                }
            }
        }

        return ans;
    }


    class Point {
        int value;
        int count;
        Point(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    // N*logK
    public int[] topKFrequentUsingMinHeap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2)->p1.count-p2.count);

        for(int key: map.keySet()) {
            pq.offer(new Point(key, map.get(key)));
            if(pq.size()>k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];

        while(k>0) {
            ans[--k] = pq.poll().value;
        }

        return ans;
    }
}
