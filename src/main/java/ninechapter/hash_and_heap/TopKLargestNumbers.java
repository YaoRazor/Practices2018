package ninechapter.hash_and_heap;

import java.util.PriorityQueue;

public class TopKLargestNumbers {

    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num: nums) {
            pq.offer(num);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] ret = new int[k];

        for(int i=k-1; i>=0; i--) {
            ret[i] = pq.poll();
        }

        return ret;
    }
}
