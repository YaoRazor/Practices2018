package ninechapter.tree.related;

import datastructures.TreeNode;

public class BinaryTreeMaximumPathSumTwo {

    // TC: O(N)
    public int maxPathSum2(TreeNode root) {
        return helper(root);
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

        return leftRes>rightRes? leftRes: rightRes;
    }
}
