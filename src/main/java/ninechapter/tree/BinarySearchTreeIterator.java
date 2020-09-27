package ninechapter.tree;

import datastructures.TreeNode;
import java.util.Stack;

// Because every node will be visited twice, therefore next() and hasNext() should run in
// amortized O(1) time. The space complexity is O(h), h is the height of the tree
public class BinarySearchTreeIterator {
    private Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        getNextElement(root);
    }

    private void getNextElement(TreeNode root) {
        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode cur = stack.pop();
        getNextElement(cur.right);
        return cur.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
