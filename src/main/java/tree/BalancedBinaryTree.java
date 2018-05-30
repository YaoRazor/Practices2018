package tree;

import datastructures.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
       return treeDepth(root) != -1;
    }


    private int treeDepth(TreeNode root) {
        if(root==null) {
            return 0;
        } else {

            int left = treeDepth(root.left);
            // 这里可以剪枝，如果遇到left=-1, 那么直接return -1
            if(left==-1) {
                return -1;
            }
            int right = treeDepth(root.right);
            if(right==-1) {
                return -1;
            }

            if(Math.abs(left-right)>1) {
                return -1;
            } else {
                return Math.max(left, right)+1;
            }

        }
    }
}
