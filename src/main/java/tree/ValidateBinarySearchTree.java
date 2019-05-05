package tree;


import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;


public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        Integer pre = null;
        Deque<TreeNode> deque = new ArrayDeque<>();

        TreeNode cur = root;

        while(cur!=null || !deque.isEmpty()) {
            while(cur!=null) {
                deque.addFirst(cur);
                cur= cur.left;
            }

            cur = deque.pollFirst();

            if(pre!=null && pre>=cur.val) {
                return false;
            }

            pre = cur.val;
            cur = cur.right;
        }

        return true;
    }
}
