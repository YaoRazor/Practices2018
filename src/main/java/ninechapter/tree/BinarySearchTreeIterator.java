package ninechapter.tree;

import datastructures.TreeNode;


import java.util.Stack;


// Because every node will be visited twice, therefore next() and hasNext() should run in average O(1) time
// The space complexity is O(h), h is the height of the tree
public class BinarySearchTreeIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        getNextElement(root);
    }

    private void getNextElement(TreeNode root) {
        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        getNextElement(cur.right);
        return cur.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
