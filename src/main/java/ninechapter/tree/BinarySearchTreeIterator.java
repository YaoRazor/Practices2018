package ninechapter.tree;

import datastructures.TreeNode;


import java.util.Stack;


// Because every node will be visited twice, therefore next() and hasNext() should run in average O(1) time
// The space complexity is O(h), h is the height of the tree
public class BinarySearchTreeIterator {

    Stack<TreeNode> stack;

    /*
     * @param root: The root of binary tree.
     */
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        getNexteElement(root);
    }

    private void getNexteElement(TreeNode cur) {
        while(cur!=null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        TreeNode cur = stack.pop();
        if(cur.right!=null) {
            getNexteElement(cur.right);
        }
        return cur;
    }
}
