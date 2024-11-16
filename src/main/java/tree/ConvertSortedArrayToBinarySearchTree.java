package tree;


import datastructures.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    // Whether you need a helper function or not depends on whether original problem ans sub-problem share the same interface
    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(start>end) {
            return null;
        }

        int mid = (end+start)/2;

        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = sortedArrayToBST(nums, start, mid-1);
        cur.right = sortedArrayToBST(nums, mid+1, end);
        return cur;
    }
}
