package tree;

import datastructures.TreeNode;

public class InvertBinaryTree {

    // Typical Divide and Conquer
    // time complexity O(n), space complexity O(n)
    public TreeNode invertTree(TreeNode root) {
        if(root==null) {
            return null;
        }

        TreeNode tmp = root.right;

        root.right = invertTree(root.left);
        root.left = invertTree(tmp);

        return root;
    }

}
