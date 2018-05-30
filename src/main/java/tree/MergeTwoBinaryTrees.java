package tree;

import datastructures.TreeNode;

/**
 * Created by yawang on 4/29/18.
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root;
        if(t1!=null && t2!=null) {
            root = new TreeNode(t1.val+t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
            return root;
        } else {
            root = t1!=null? t1:t2;
            return root;
        }

    }
}
