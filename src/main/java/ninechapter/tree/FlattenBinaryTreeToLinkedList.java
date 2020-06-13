package ninechapter.tree;

import datastructures.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        flatternAndReturnLastNode(root);
    }

    private TreeNode flatternAndReturnLastNode(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) {
            return root;
        }

        TreeNode leftLast = flatternAndReturnLastNode(root.left);
        TreeNode rightLast = flatternAndReturnLastNode(root.right);
        if (leftLast != null) {
            leftLast.right = root.right;
            // Only do this when left side is not null, otherwise, we will loose nodes on the right side
            root.right = root.left;
            root.left = null;
        }

        return rightLast!=null? rightLast:leftLast;
    }
}
