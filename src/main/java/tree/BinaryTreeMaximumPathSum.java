package tree;

import datastructures.TreeNode;

public class BinaryTreeMaximumPathSum {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root==null) {
            return 0;
        }

        dfs(root);
        return ans;
    }


    private int dfs(TreeNode root) {
        int cur = root.val;
        int left = 0;
        int right = 0;

        if(root.left!=null) {
            left = dfs(root.left);
        }

        if(root.right!=null) {
            right = dfs(root.right);
        }

        int middle = left+right+cur;

        cur = Math.max(left, right)>0? Math.max(left, right)+cur: cur;
        ans = Math.max(ans, cur);
        ans = Math.max(ans, middle);
        return cur;
    }
}
