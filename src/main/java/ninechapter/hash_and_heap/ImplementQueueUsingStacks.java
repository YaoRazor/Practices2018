package ninechapter.hash_and_heap;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacks {
    Deque<Integer> stackOne = new ArrayDeque<>();
    Deque<Integer> stackTwo = new ArrayDeque<>();

    public ImplementQueueUsingStacks() {
        // do intialization if necessary
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        stackOne.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if(!stackTwo.isEmpty()) {
            return stackTwo.pop();
        }

        while(!stackOne.isEmpty()) {
            stackTwo.push(stackOne.pop());
        }

        return stackTwo.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        int ret = pop();
        stackTwo.push(ret);
        return ret;
    }
}
