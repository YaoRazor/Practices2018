package ninechapter.hash_and_heap.optional;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementStack {
    private Deque<Integer> deque = new ArrayDeque<>();
    private int top;
    /*
     * @param x: An integer
     * @return: nothing
     */
    public void push(int x) {
        deque.addLast(x);

        // write your code here
    }

    /*
     * @return: nothing
     */
    public void pop() {
        deque.removeLast();
        // write your code here
    }

    /*
     * @return: An integer
     */
    public int top() {
        int top = deque.removeLast();
        deque.addLast(top);
        return top;
        // write your code here
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return deque.isEmpty();
        // write your code here
    }
}
