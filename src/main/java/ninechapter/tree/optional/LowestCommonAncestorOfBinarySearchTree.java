package ninechapter.tree.optional;

import datastructures.TreeNode;

public class LowestCommonAncestorOfBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = root;
        while((long)(ans.val-p.val) * (long)(ans.val-q.val)>0) {
            if(ans.val>p.val) {
                ans = ans.left;
            } else {
                ans = ans.right;
            }
        }

        return ans;
    }
}
