package tree;


import datastructures.TreeNode;

// The most important assumption of this question is that
// there will be a common ancestor for this question
public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null || root==p || root==q) {
            return root;
        }


        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left!=null && right!=null) {
            return root;
        } else {
            return left==null? right: left;
        }

    }


}
