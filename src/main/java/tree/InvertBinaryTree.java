package tree;

import datastructures.TreeNode;

public class InvertBinaryTree {

    // 典型的Divide and Conquer
    public TreeNode invertTree(TreeNode root) {
        if(root==null) {
            return root;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        return root;
    }

}
