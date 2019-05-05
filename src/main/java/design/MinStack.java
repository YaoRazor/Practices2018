package design;

import java.util.ArrayDeque;
import java.util.Deque;

// 有使用一个stack实现的版本，但是和两个stack的本质是一样的
public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {

        stack.push(x);

        if(minStack.isEmpty() || x<=getMin()) {
            minStack.push(x);
        }
    }

    public void pop() {

        Integer cur = stack.pop();
        if(cur==getMin()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
