package ninechapter.tree.optional;

import datastructures.TreeNode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // Do not forget the base case of root==null which is
        // the base case that neither A nor B is in current tree branch
        if(root==A || root==B || root==null) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if(left!=null && right!=null) {
            return root;
        }

        return left!=null? left: right;
    }
}
