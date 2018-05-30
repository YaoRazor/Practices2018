package tree;


import java.util.HashMap;

import datastructures.TreeNode;

public class CountUnivalueSubtrees {

    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if(root==null) {
            return 0;
        }

        helper(root);
        return count;
    }


    private boolean helper(TreeNode root) {
        if(root==null) {
            return true;
        }

        if(root.left==null && root.right==null) {
            count++;
            return true;
        }

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if(!left || !right) {
            return false;
        }

        if(root.left==null || (root.left!=null && root.val == root.left.val)) {
            if(root.right == null || (root.right!=null && root.val == root.right.val)) {
                count++;
                return true;
            }

        }

        return false;
    }

}
