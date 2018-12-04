package design;

import datastructures.TreeNode;


import java.util.Stack;


// Because every node will be visited twice, therefore next() and hasNext() should run in average O(1) time
// The space complexity is O(h), h is the height of the tree
public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {

        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {

        TreeNode cur = stack.pop();
        int ans = cur.val;

        cur = cur.right;

        while(cur!=null) {
            stack.push(cur);
            cur = cur.left;
        }

        return ans;

    }
}
