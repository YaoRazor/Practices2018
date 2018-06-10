package tree;

import java.util.Stack;

import datastructures.TreeNode;

/**
 * Created by yawang on 6/4/18.
 */
public class SumOfLeftLeaves {


    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {

        TreeNode parent = new TreeNode(-1);
        parent.left = root;

        preOrderTraversal(root.left, parent);
        return sum;
    }


    private void preOrderTraversal(TreeNode root, TreeNode parent) {
        if(root==null) {
            return;
        }

        if(root.left==null && root.right==null && root == parent.left) {
            sum+=root.val;
        }


        preOrderTraversal(root.left, root);
        preOrderTraversal(root.right, root);

    }


    public int sumOfLeftLeavesIterative(TreeNode root) {

        if(root==null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;

        stack.push(root);

        while (stack.isEmpty()) {

            TreeNode cur = stack.pop();

            if(cur.right!=null) {
                //这个条件是一个剪枝，不要也行，也能work，就是慢一点
                if(cur.right.left!=null || cur.right.right!=null) {
                    stack.push(cur.right);
                }
            }

            if(cur.left!=null) {
                if(cur.left.left==null && cur.left.right ==null) {
                    sum+=cur.left.val;
                }

                stack.push(cur.left);
            }


        }

        return sum;
    }



}
