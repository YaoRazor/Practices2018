package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    // max heap
    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    // min heap
    PriorityQueue<Integer> big = new PriorityQueue<>();

    public void addNum(int num) {

        if(small.size()==big.size()) {
            big.add(num);
            small.add(big.poll());
        } else {
            small.add(num);
            big.add(small.poll());
        }

    }

    public double findMedian() {

        if(small.size()>big.size()) {
            return small.peek()*1.0;
        } else {
            return (small.peek() + big.peek())/2.0;
        }

    }
}
