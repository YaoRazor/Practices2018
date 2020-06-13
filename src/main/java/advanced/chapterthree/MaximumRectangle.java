package advanced.chapterthree;

import java.util.Stack;

public class MaximumRectangle {

    // O(N^2)
    public int maximalRectangle(boolean[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] height = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i==0) {
                    height[i][j] = matrix[i][j]?1:0;
                } else {
                    height[i][j] = matrix[i][j]? 1+ height[i-1][j]:0;
                }
            }
        }

        int maxArea = 0;

        for(int i=0; i<n; i++) {
            maxArea = Math.max(maxArea, largestRectangleArea(height[i]));
        }

        return maxArea;
    }


    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i=0; i<=height.length; i++) {
            int cur = i==height.length? 0: height[i];

            while(!stack.isEmpty() && cur<=height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty()? i: i-1-stack.peek();
                ans = Math.max(ans, h*w);
            }

            stack.push(i);
        }

        return ans;
    }
}
