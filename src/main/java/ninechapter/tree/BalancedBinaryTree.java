package ninechapter.tree;

import datastructures.TreeNode;

// This is a classic example to use divide and conquer algorithm
public class BalancedBinaryTree {
    class ResultType {
        public boolean isBalanced;
        public int depth;

        public ResultType(boolean isBalanced, int depth) {
            this.isBalanced = isBalanced;
            this.depth = depth;
        }

    }

    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    private ResultType helper(TreeNode root) {
        if(root==null) {
            return new ResultType(true, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        if(!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }

        if(Math.abs(left.depth-right.depth)>1) {
            return new ResultType(false, -1);
        }

        return new ResultType(true, Math.max(left.depth, right.depth)+1);
    }
}
