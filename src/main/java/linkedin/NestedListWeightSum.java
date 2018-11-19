package linkedin;


import datastructures.NestedInteger;

import java.util.List;
import java.util.Stack;

public class NestedListWeightSum {

    // 这一题是比较典型的recursive的解法，一般来说对于Recursive的解法，用栈来做肯定也可以
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList==null) {
            return 0;
        }

        return depthSum(nestedList, 1);
    }

    private int depthSum(List<NestedInteger> nestedList, int level) {
        int ans = 0;

        for(NestedInteger nestedInteger: nestedList) {

            if(nestedInteger.isInteger()) {
                ans+=nestedInteger.getInteger()*level;
            } else {
                ans+=depthSum(nestedInteger.getList(), level+1);
            }

        }

        return ans;

    }


    // 用栈的做法，要存一下当前层的weight
    public int depthSumUsingStack(List<NestedInteger> nestedList) {
        Stack<Pair> stack = new Stack<Pair>();
        stack.push(new Pair(nestedList, 1));
        int sum = 0;
        while (!stack.isEmpty()) {
            Pair top = stack.pop();
            for (NestedInteger nestedInteger : top.nestedList) {
                if (nestedInteger.isInteger()) {
                    sum += (top.depth * nestedInteger.getInteger());
                } else {
                    stack.push(new Pair(nestedInteger.getList(), top.depth + 1));
                }
            }
        }

        return sum;
    }

    private static class Pair {
        List<NestedInteger> nestedList;
        int depth;

        public Pair(List<NestedInteger> nestedList, int depth) {
            this.nestedList = nestedList;
            this.depth = depth;
        }
    }
}
