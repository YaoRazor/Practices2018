package ninechapter.tree;

import datastructures.TreeNode;

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        TreeNode cur = root;

        while(cur!=null) {
            if(Math.abs(cur.val-target)<Math.abs(res-target)) {
                res = cur.val;
            }
            if(cur.val==target) {
                break;
            } else if(cur.val>target) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        return res;
    }
}
