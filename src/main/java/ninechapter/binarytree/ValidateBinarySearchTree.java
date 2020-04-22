package ninechapter.binarytree;


import datastructures.TreeNode;
import java.util.Stack;


public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        Integer pre = null;

        while(cur!=null || !stack.isEmpty()) {
            while(cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if(pre!=null && cur.val<=pre) {
                return false;
            }
            pre = cur.val;
            cur = cur.right;
        }

        return true;
    }
}
