package tree;

import datastructures.TreeNode;


public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {

        if(root == null || root.left==null) {
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left);

        root.left.right = root;
        root.left.left = root.right;
        root.left = null;
        root.right = null;

        return newRoot;

    }
}
