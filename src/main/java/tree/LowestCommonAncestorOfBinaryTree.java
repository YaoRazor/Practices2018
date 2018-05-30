package tree;

import datastructures.TreeNode;

/**
 * Created by yawang on 3/13/18.
 */
public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode cur = root;

        while(cur!=null) {

            if(isSubTree(cur.left, p) && isSubTree(cur.left, q)) {
                cur = cur.left;
            } else if(isSubTree(cur.right, p) && isSubTree(cur.right, q)) {
                cur = cur.right;
            } else {
                break;
            }

        }

        return cur;
    }

    private boolean isSubTree(TreeNode root, TreeNode p) {

        if(root == null) {
            return false;
        }

        if(root == p) {
            return true;
        } else if(isSubTree(root.left, p)) {
            return true;
        } else if(isSubTree(root.right, p)) {
            return  true;
        } else {
            return false;
        }

    }
}
