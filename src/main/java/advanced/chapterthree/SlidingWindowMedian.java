package advanced.chapterthree;

import java.util.*;

public class SlidingWindowMedian {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    // min heap
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if(nums==null || nums.length==0) {
            return ans;
        }

        for(int i=0; i<nums.length; i++) {
            if(maxHeap.size()==0 || nums[i]<=maxHeap.peek()) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }

            // 这一步必须放在balance之前，防止k==2的时候，如果放在后面remove了
            // maxHeap里的值导致在19行把更大的值加入了maxHeap，使得maxHeap里的
            // 值必须要比minHeap小的这个invariant给break了
            if(i-k>=0) {
                if(nums[i-k]>maxHeap.peek()) {
                    minHeap.remove(nums[i-k]);
                } else {
                    maxHeap.remove(nums[i-k]);
                }
            }

            balance();

            if(i>=k-1) {
                ans.add(maxHeap.peek());
            }
        }

        return ans;
    }


    private void balance() {
        if(maxHeap.size()>minHeap.size()+1) {
            minHeap.offer(maxHeap.poll());
        }

        if(minHeap.size()>maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
}
