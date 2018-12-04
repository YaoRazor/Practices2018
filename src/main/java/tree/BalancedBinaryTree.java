package tree;

import datastructures.TreeNode;

public class BalancedBinaryTree {

    // 还可以采用ResultType, 同时返回isBalanced和TreeDepth, 这种方法更正统一点
    // 本题的方法其实有一些hacky,相当于return value同时用于表示tree depth和是否balanced

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
