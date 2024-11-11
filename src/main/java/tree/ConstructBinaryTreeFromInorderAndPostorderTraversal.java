package tree;

import datastructures.TreeNode;

// The average time complexity is O(n*logn) when tree is balanced
// The worst case is O(n^2) when tree is not balanced
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null || postorder.length==0 || inorder==null || inorder.length==0
                || postorder.length!=inorder.length) {
            return null;
        }

        return buildTree(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] postorder, int startp, int endp,
                              int[] inorder, int starti, int endi) {
        if(startp>endp) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[endp]);

        int index = findIndex(inorder, starti, endi, postorder[endp]);

        root.left = buildTree(postorder, startp, startp-starti+index, inorder, starti, index-1);
        root.right =  buildTree(postorder, startp-starti+index+1, endp, inorder, index+1, endi);

        return root;
    }

    private int findIndex(int[] inorder, int start, int end, int value) {
        for(int i = start; i<=end; i++) {
            if(value==inorder[i]) {
                return i;
            }
        }
        throw new RuntimeException();
    }
}
