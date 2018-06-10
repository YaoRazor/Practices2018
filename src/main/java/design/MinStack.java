package design;

import java.util.Stack;

//我们这个方法使用了两个stack, 其实还可以通过amend数据结构来实现
//但是思想是一样的，都是需要额外的内存
public class MinStack {
    /** initialize your data structure here. */

    Stack<Integer> internalStack;
    Stack<Integer> min;

    public MinStack() {
        internalStack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        internalStack.push(x);

        if(min.isEmpty()|| x<=min.peek()) { //这里又两个要点：一个是check empty，还有一个是<=
            min.push(x);
        }

    }

    public void pop() {
        if(internalStack.peek()==getMin()) {
            min.pop();
        }

        internalStack.pop();
    }

    public int top() {
        return internalStack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
