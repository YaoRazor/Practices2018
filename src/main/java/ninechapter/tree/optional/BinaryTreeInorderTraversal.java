package ninechapter.tree.optional;

import java.util.*;

import datastructures.TreeNode;


public class  BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();
        inorderTraversal(root, integerList);
        return integerList;
    }

    private void inorderTraversal(TreeNode root, List<Integer> integerList) {
        if(root!=null) {
            inorderTraversal(root.left, integerList);
            integerList.add(root.val);
            inorderTraversal(root.right, integerList);
        } else {
            return;
        }
    }

    public List<Integer> inorderTraversalInterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur!=null || !stack.isEmpty()) {
            // When the node is not null, we need to find its
            // leftmost TreeNode
            while(cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }
            // Everytime the TreeNode was poped from the stack,
            // it means all nodes in the left subtree has been
            // processed.
            cur = stack.pop();
            // We process the middle node
            ans.add(cur.val);
            // We start to process the right sub tree
            cur = cur.right;
        }

        return ans;
    }
}
