package companies.lyft;

import java.util.Stack;

public class MaxStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();

    /** initialize your data structure here. */
    public MaxStack() {

    }

    // 你的这种做法是当x比你的maxStack的top大的时候才push, LeetCode的答案里其实是每次都push
    // 你的这个做法省空间一点，但是逻辑稍微复杂一些，那个做法就是算法简单，但是两倍空间
    // 所以你的这个做法好一些
    public void push(int x) {
        stack.push(x);

        if(maxStack.isEmpty() || x>=peekMax()) {
            maxStack.push(x);
        }
    }

    public int pop() {
        int cur = stack.pop();
        if(cur==peekMax()) {
            maxStack.pop();
        }
        return cur;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    // popMax的定义是把最大的元素给pop出来，把其他的给塞回去
    public int popMax() {
        int curMax = peekMax();
        Stack<Integer> buffer = new Stack<>();

        while(true) {
            int cur = pop();
            if(cur==curMax) {
                break;
            }
            buffer.push(cur);
        }

        while(!buffer.isEmpty()) {
            push(buffer.pop());
        }

        return curMax;
    }
}
