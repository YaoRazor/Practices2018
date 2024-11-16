package advanced.chapterthree;

import java.util.Stack;



//Algorithm：
//用九章算法强化班中讲过的单调栈(stack)。维护一个单调递增栈，逐个将元素 push 到栈里。push 进去之前先把 >= 自己的元素 pop 出来。
//并且计算这些被pop出来的数所形成的最大histogram
//每次从栈中 pop 出一个数的时候，就找到了往左数比它小的第一个数（当前栈顶）和往右数比它小的第一个数（即将入栈的数），
//从而可以计算出这两个数中间的部分宽度 * 被pop出的数，就是以这个被pop出来的数为最低(短板)的那个直方向两边展开的最大矩阵面积。
public class LargestRectangleInHistogram {

    // TC: O(N)
    public int largestRectangleArea(int[] height) {
        if(height==null || height.length==0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for(int i=0; i<=height.length; i++) {
            int cur = i==height.length? 0: height[i];

            // 注意这里是cur<=height[stack.peek()], because we push index into the stack
            while(!stack.isEmpty() && cur<=height[stack.peek()]) {
                int h = height[stack.pop()];
                // i means (i-1-(-1)), when stack is empty, the left index that is
                // smaller than this will be -1
                int w = stack.isEmpty()? i: i-1-stack.peek();
                ans = Math.max(h*w, ans);
            }

            //每个元素都要进栈, no need to psh when i==height.length
            stack.push(i);
        }

        return ans;
    }
}
