package dummy;

import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStackUsingQueue {
    Queue<Integer> cur = new ArrayDeque<>();

    /** Initialize your data structure here. */
    public ImplementStackUsingQueue() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        cur.offer(x);
        // The key to this problem is to rotate cur.size()-1 times
        for(int i=0; i<cur.size()-1; i++) {
            cur.offer(cur.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return cur.poll();
    }

    /** Get the top element. */
    public int top() {
        return cur.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return cur.isEmpty();
    }
}
