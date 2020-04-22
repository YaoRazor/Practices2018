package ninechapter.binarytree;


import datastructures.TreeNode;


public class LowestCommonAncestorOfABinaryTree {

    class ResultType {
        public TreeNode lca;
        public boolean isNodeA;
        public boolean isNodeB;
        public ResultType(TreeNode lca,boolean isNodeA, boolean isNodeB) {
            this.lca = lca;
            this.isNodeA = isNodeA;
            this.isNodeB = isNodeB;
        }
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        ResultType ans = lowestCommonAncestor(root, A, B);
        if(ans.isNodeA && ans.isNodeB) {
            return ans.lca;
        }
        return null;
    }

    private ResultType lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if(root==null) {
            return new ResultType(null, false, false);
        }

        ResultType left = lowestCommonAncestor(root.left, A, B);
        ResultType right = lowestCommonAncestor(root.right, A, B);

        if(left.isNodeA && left.isNodeB) {
            return left;
        } else if(right.isNodeA && right.isNodeB) {
            return right;
        }

        boolean isLeft = left.isNodeA || right.isNodeA;
        boolean isRight = left.isNodeB || right.isNodeB;

        if(isLeft && isRight) {
            return new ResultType(root, true, true);
        }

        if(root==A) {
            isLeft = true;
        }

        if(root==B) {
            isRight = true;
        }

        return new ResultType(root, isLeft, isRight);
    }


}
