package tree;

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
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        while(cur!=null || !stack.isEmpty()) {
            while(cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }

        return ans;
    }
}
