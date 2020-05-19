package ninechapter.tree;

import java.util.Stack;

import datastructures.TreeNode;

// For follow-up question, we can augment the tree with count, then do
// changes when inserting or deleting
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int ans = 0;

        while(cur!=null || !stack.isEmpty()) {
            while(cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            k--;
            if(k==0) {
                ans = cur.val;
                break;
            }
            cur = cur.right;
        }

        return ans;
    }
}
