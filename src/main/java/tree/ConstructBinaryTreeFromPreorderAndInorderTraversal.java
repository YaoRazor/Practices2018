package tree;


import datastructures.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder==null || preorder.length==0 || inorder==null || inorder.length==0
                || preorder.length!=inorder.length) {
            return null;
        }

        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);

    }



    public TreeNode buildTree(int[] preorder, int startp, int endp,
                              int[] inorder, int starti, int endi) {

        if(startp>endp) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[startp]);

        int index = findIndex(inorder, starti, endi, preorder[startp]);

        root.left = buildTree(preorder, startp+1, startp-starti+index, inorder, starti, index-1);
        root.right =  buildTree(preorder, startp-starti+index+1, endp, inorder, index+1, endi);

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
