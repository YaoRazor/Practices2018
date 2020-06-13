package advanced.chapterthree;

import datastructures.TreeNode;

import java.util.Stack;

public class MaxTree {

    // Divide and conquer: O(nlogn)
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if(start>end) {
            return null;
        } else if(start==end) {
            return new TreeNode(nums[start]);
        }

        int index = start;
        for(int i=start+1; i<=end; i++) {
            if(nums[i]>nums[index]) {
                index = i;
            }
        }

        TreeNode root = new TreeNode(nums[index]);
        root.left = constructMaximumBinaryTree(nums, start, index-1);
        root.right = constructMaximumBinaryTree(nums, index+1, end);
        return root;
    }

    // TC: O(n)
    // https://leetcode.com/problems/maximum-binary-tree/discuss/106156/Java-worst-case-O(N)-solution
    // basically before we insert any element in the tree, we are keeping the right side view of the tree
    // in the stack
    public TreeNode maxTree(int[] A) {
        if(A==null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();

        for(int i=0; i<A.length; i++) {
            TreeNode cur = new TreeNode(A[i]);
            while(!stack.isEmpty() && stack.peek().val<A[i]) {
                cur.left = stack.pop();
            }

            if(!stack.isEmpty()) {
                stack.peek().right = cur;
            }

            stack.push(cur);
        }

        TreeNode root = null;

        // The first element in the stack is the root.
        while(!stack.isEmpty()) {
            root = stack.pop();
        }

        return root;
    }
}
