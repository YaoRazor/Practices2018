package advanced.chapterthree;


import java.util.Collections;
import java.util.PriorityQueue;

// leetcode and lintcode has different forms of this problem
// TC: O(nlogn)
public class FindMedianFromDataStream {
    // max heap
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    // min heap
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void addNum(int num) {
        if(maxHeap.size()==0 || num<=maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if(maxHeap.size()>minHeap.size()+1) {
            minHeap.offer(maxHeap.poll());
        }

        if(minHeap.size()>maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size()> minHeap.size()) {
            return maxHeap.peek()*1.0;
        } else {
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
    }


    public int[] medianII(int[] nums) {
        if(nums==null || nums.length==0) {
            return new int[]{};
        }

        int[] ans = new int[nums.length];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2)->i2-i1);

        for(int i=0; i<nums.length; i++) {
            if(maxHeap.size()==0 || nums[i]<=maxHeap.peek()) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }

            if(maxHeap.size()>minHeap.size()+1) {
                minHeap.offer(maxHeap.poll());
            }

            if(minHeap.size()>maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            ans[i] = maxHeap.peek();
        }

        return ans;
    }
}
