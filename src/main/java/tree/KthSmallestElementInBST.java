package tree;

import java.util.Stack;

import datastructures.TreeNode;

// For follow-up question, we can augment the tree with count, then do
// changes when inserting or deleting
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> formerNodes = new Stack<>();

        while(root!=null || !formerNodes.isEmpty()) {

            while(root!=null) {
                formerNodes.push(root);
                root = root.left;
            }

            root = formerNodes.pop();

            if(--k==0) {
                return root.val;
            }

            root = root.right;
        }

        return -1;

    }
}
