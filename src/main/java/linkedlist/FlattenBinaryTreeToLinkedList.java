package linkedlist;

import datastructures.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        flatternAndRetrunTail(root);
    }

    private TreeNode flatternAndRetrunTail(TreeNode root) {

        if(root==null) {
            return null;
        }

        if(root.left==null && root.right==null) {
            return root;
        }

        TreeNode tmp = root.right;

        if(root.left!=null) {
            TreeNode tail = flatternAndRetrunTail(root.left);
            root.right = root.left;
            tail.right = tmp;
            root.left = null;

            if(tmp!=null) {
                return flatternAndRetrunTail(tmp);
            } else {
                return tail;
            }


        } else {
            return flatternAndRetrunTail(tmp);
        }

    }
}
