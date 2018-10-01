package tree;

import datastructures.TreeNode;

import java.util.ArrayDeque;

public class InorderSuccessorinBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode res = null;
        while(root!=null) {
            if(root.val > p.val) {
                res = root;
                root = root.left;
            }
            else root = root.right;
        }
        return res;

    }

    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode res = null;

        while (root!=null) {

            if(root.val<p.val) {
                res = root;
                root = root.right;

            } else {
                root = root.left;
            }

        }

        return res;

    }
}
