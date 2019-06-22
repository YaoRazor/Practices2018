package bst;

import datastructures.TreeNode;

public class LowestCommonAncestorOfBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;

        while((cur.val-p.val)*(cur.val-q.val) > 0) {
            cur = cur.val-p.val>0? cur.left: cur.right;
        }

        return cur;
    }
}
