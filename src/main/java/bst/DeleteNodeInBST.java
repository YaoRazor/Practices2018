package bst;

import datastructures.TreeNode;

public class DeleteNodeInBST {
    // The first answer to the most popular voted solution
    public TreeNode deleteNode(TreeNode root, int val) {
        if(root==null) {
            return null;
        }

        if(root.val < val) {
            // Recursion is a great idea so that you don't have to track the parent node
            root.right = deleteNode(root.right, val);
            return root;
        } else if(root.val> val) {
            root.left = deleteNode(root.left, val);
            return root;
        }

        if(root.left==null) {
            return root.right;
        } else if(root.right==null) {
            return root.left;
        }

        TreeNode rightSmallest = root.right;

        while(rightSmallest.left!=null) {
            rightSmallest = rightSmallest.left;
        }

        // Move the left tree of root as the left tree of rightSmallest
        rightSmallest.left = root.left;
        return root.right;
    }

}
