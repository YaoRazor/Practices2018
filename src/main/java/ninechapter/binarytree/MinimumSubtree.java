package ninechapter.binarytree;

import datastructures.TreeNode;

public class MinimumSubtree {
    private TreeNode subtree;
    private int minimumSum = Integer.MAX_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        findSubtreeSum(root);
        return subtree;
    }

    private int findSubtreeSum(TreeNode root) {
        if(root==null) {
            return 0;
        }

        int leftSum = findSubtreeSum(root.left);
        int rightSum = findSubtreeSum(root.right);
        int total = leftSum+rightSum+root.val;

        if(total<minimumSum) {
            subtree = root;
            minimumSum = total;
        }

        return total;
    }
}
