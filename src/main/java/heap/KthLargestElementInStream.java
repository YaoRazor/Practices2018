package heap;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;

    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        for(int num: nums) {
            pq.offer(num);
            if(pq.size()>k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.offer(val);
        if(pq.size()>k) {
            pq.poll();
        }

        return pq.peek();
    }
}
