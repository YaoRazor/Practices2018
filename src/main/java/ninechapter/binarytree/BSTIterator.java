package ninechapter.binarytree;

import datastructures.TreeNode;


import java.util.Stack;


// Because every node will be visited twice, therefore next() and hasNext() should run in average O(1) time
// The space complexity is O(h), h is the height of the tree
public class BSTIterator {

    TreeNode cur;
    Stack<TreeNode> stack = new Stack<>();

    /*
     * @param root: The root of binary tree.
     */public BSTIterator(TreeNode root) {
        cur = root;
        findNextNode();

    }

    private void findNextNode() {
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
        cur = stack.pop();
        TreeNode ans = cur;
        cur = cur.right;
        findNextNode();
        return ans;
        // write your code here
    }
}
