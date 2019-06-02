package tree;

import datastructures.TreeNode;

public class SumRoottoLeafNumbers {

    int sum = 0;


    public int sumNumbers(TreeNode root) {
        if(root==null) {
            return 0;
        }

        dfs(root, 0);
        return sum;
    }


    private void dfs(TreeNode root, int cur) {
        if(root.left==null && root.right == null) {
            sum+= cur*10+root.val;
            return;
        }

        cur = cur*10+root.val;

        if(root.left!=null) {
            dfs(root.left, cur);
        }


        if(root.right!=null) {
            dfs(root.right, cur);
        }
    }

    public int sumNumbersDAC(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int cur) {
        if(root==null) {
            return 0;
        }

        if(root.left==null && root.right==null) {
            return cur*10+root.val;
        }

        return sumNumbers(root.left, cur*10+root.val)+sumNumbers(root.right, cur*10+root.val);
    }
}
