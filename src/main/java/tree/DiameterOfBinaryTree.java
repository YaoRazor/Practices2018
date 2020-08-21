package tree;


import datastructures.TreeNode;


// The key of this problem is to decouple the
// status update and return value, we can also pass in a
// array of length 1 to prevent us from updating global variable
public class DiameterOfBinaryTree {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        treeDepth(root);
        return ans;
    }

    private int treeDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        // We need to get the max, because the lower node's diameter
        // can be bigger than the parent one
        ans = Math.max(ans, left+right);

        return Math.max(left, right) + 1;
    }
}
