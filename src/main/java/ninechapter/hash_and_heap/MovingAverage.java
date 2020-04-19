package ninechapter.hash_and_heap;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverage {
    private double total = 0;
    private Deque<Integer> deque = new ArrayDeque<>();
    private int size = 0;
    /*
     * @param size: An integer
     */public MovingAverage(int size) {
        this.size = size;
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
        deque.addLast(val);
        total+=val;
        if(deque.size()>size) {
            int pre = deque.removeFirst();
            total-=pre;
        }

        return total/deque.size();
        // write your code here
    }
}
