package tree;

import datastructures.TreeNode;

/**
 * Created by yawang on 4/22/18.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) {
            return true;
        } else if(p!=null && q!=null) {

            return p.val == q.val &&
                    isSameTree(p.left, q.left) && isSameTree(p.right, p.right);
        } else {
            return false;
        }

    }



}
