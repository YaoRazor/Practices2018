package ninechapter.binarytree.optional;

import datastructures.TreeNode;

public class InorderPredecessorinBST {
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
