package ninechapter.tree.related;

import datastructures.TreeNode;

public class BinaryTreeMaximumPathSum {
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPathDown(root);
        return maxPathSum;
    }

    private int getMaxPathDown(TreeNode root) {
        if(root==null) {
            return 0;
        }

        // 这个和0比较非常重要，这个相当于可以舍去负的branch，
        // 这个实际上是这一道题的核心
        int left = Math.max(0, getMaxPathDown(root.left));
        int right = Math.max(0, getMaxPathDown(root.right));

        maxPathSum = Math.max(maxPathSum, left+right+root.val);
        return Math.max(left, right)+root.val;
    }
}
