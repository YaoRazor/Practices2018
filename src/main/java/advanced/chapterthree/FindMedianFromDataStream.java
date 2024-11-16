package advanced.chapterthree;


import java.util.Collections;
import java.util.PriorityQueue;


// TC: O(nlogn)
public class FindMedianFromDataStream {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    /** initialize your data structure here. */
    public FindMedianFromDataStream() {

    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || num<=maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        balance();
    }

    private void balance() {
        if(maxHeap.size()>minHeap.size()+1) {
            minHeap.offer(maxHeap.poll());
        }

        // this is to make sure maxHeap always have
        // more elements than minHeap as in the findMedian
        // method, we always try to return from maxHeap
        if(minHeap.size()>maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size()==minHeap.size()) {
            return (maxHeap.peek()+minHeap.peek())/2.0;
        } else {
            return (double)maxHeap.peek();
        }
    }

}
