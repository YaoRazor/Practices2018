package ninechapter.tree.related;

import datastructures.TreeNode;

public class BinaryTreeMaximumPathSum {

    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxPathSum;
    }


    private int helper(TreeNode root) {
        if(root==null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        int leftRes = root.val, rightRes = root.val;
        leftRes = Math.max(leftRes, leftRes+left);
        rightRes = Math.max(rightRes, rightRes+right);

        maxPathSum = Math.max(leftRes+rightRes-root.val, maxPathSum);

        return leftRes>rightRes? leftRes: rightRes;
    }
}
