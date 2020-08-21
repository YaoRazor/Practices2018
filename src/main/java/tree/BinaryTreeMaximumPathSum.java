package tree;

import datastructures.TreeNode;

//这个解法实际上是Divide And Conquer和DFS相结合的方法
public class BinaryTreeMaximumPathSum {
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPathDown(root);
        return maxPathSum;
    }

    // 这个getMaxPathDown代表的是从这一点到底部的最大路径和，
    // 这个路径至少要有一个点，但是不一定要到树的底部
    private int getMaxPathDown(TreeNode root) {
        if(root==null) {
            return 0;
        }

        int left = Math.max(0, getMaxPathDown(root.left));
        int right = Math.max(0, getMaxPathDown(root.right));

        maxPathSum = Math.max(maxPathSum, left+right+root.val);
        return Math.max(left, right)+root.val;
    }
}
