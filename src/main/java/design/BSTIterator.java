package design;

import datastructures.TreeNode;

import java.util.ArrayDeque;

public class BSTIterator {

    ArrayDeque<TreeNode> deque = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {

        while (root!=null) {
            deque.addFirst(root);
            root = root.left;
        }

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !deque.isEmpty();
    }

    // The tree will be iterated twice in the whole process, that is why this next is average O(1)
    public int next() {

        TreeNode cur = deque.removeFirst();
        int ans = cur.val;

        if(cur.right!=null) {
            cur = cur.right;

            while (cur!=null) {
                deque.addFirst(cur);
                cur = cur.left;
            }

        }

        return ans;
    }
}
