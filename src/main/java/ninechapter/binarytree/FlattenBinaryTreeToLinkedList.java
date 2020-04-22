package ninechapter.binarytree;

import datastructures.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        // write your code here
        flatternAndReturnLastNode(root);
    }

    private TreeNode flatternAndReturnLastNode(TreeNode root) {
        if (root == null) return null;
        TreeNode leftLast = flatternAndReturnLastNode(root.left);
        TreeNode rightLast = flatternAndReturnLastNode(root.right);
        if (leftLast != null) {
            leftLast.right = root.right;
            // Only do this when left side is not null, otherwise, we will loose nodes on the right side
            root.right = root.left;
            root.left = null;
        }

        if(leftLast==null && rightLast==null) {
            return root;
        }

        return rightLast!=null? rightLast:leftLast;
    }
}
