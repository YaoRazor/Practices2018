package tree;


import java.util.Stack;

import datastructures.TreeNode;


public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> formerNodes = new Stack<>();

        TreeNode pre = null;

        while(root!=null || !formerNodes.isEmpty()) {

            while(root!=null) {
                formerNodes.push(root);
                root = root.left;
            }

            root = formerNodes.pop();

            if(pre!=null && pre.val>=root.val) {
                return false;
            }

            pre = root;
            root = root.right;

        }

        return true;
    }
}
