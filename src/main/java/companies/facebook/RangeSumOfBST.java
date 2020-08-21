package companies.facebook;

import datastructures.TreeNode;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null) {
            return 0;
        }

        int sum = 0;

        if(root.val>R) {
            sum+= rangeSumBST(root.left, L, R);
        } else if(root.val<L) {
            sum+= rangeSumBST(root.right, L, R);
        } else {
            sum+=root.val;
            sum+= rangeSumBST(root.left, L, R);
            sum+= rangeSumBST(root.right, L, R);
        }

        return sum;
    }
}
