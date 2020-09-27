package advanced.chapterthree;

import java.util.*;

// TC:O(nk), because the remove operation in heap is O(k)
public class SlidingWindowMedian {

    // 这里必须要用reverseOrder不能用(i1, i2)-> i2-i1，因为测试数据
    // 如果有Integer.MAX_VALUE, Integer.MIN_VALUE会溢出
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length-k+1];
        int index = 0;

        for(int i=0; i<nums.length; i++) {
            if(maxHeap.isEmpty() || nums[i]<=maxHeap.peek()) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }

            // 这一步必须放在balance之前，防止k==2的时候，如果放在后面remove了
            // maxHeap里的值导致在19行把更大的值加入了maxHeap，使得maxHeap里的
            // 值必须要比minHeap小的这个invariant给break了
            if(i>=k) {
                if(nums[i-k]<=maxHeap.peek()) {
                    maxHeap.remove(nums[i-k]);
                } else {
                    minHeap.remove(nums[i-k]);
                }
            }

            balance();

            if(i>=k-1) {
                if(k%2==1){
                    ans[index++] = maxHeap.peek();
                } else {
                    ans[index++] = ((double)maxHeap.peek()+(double)minHeap.peek())/2.0;
                }
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
