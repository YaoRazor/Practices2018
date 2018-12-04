package tree;

import datastructures.TreeNode;

public class InvertBinaryTree {

    // 典型的Divide and Conquer
    public TreeNode invertTree(TreeNode root) {

        if(root==null) {
            return root;
        }

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
