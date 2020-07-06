package ninechapter.tree.related;

import datastructures.TreeNode;

public class BinaryTreeLongestConsecutiveSequenceTwo {

    // 这里的up and down不包括自己，这是这一题的解题要点
    class ResultType {
        public int len;
        public int up;
        public int down;
        ResultType(int len, int up, int down) {
            this.len = len;
            this.up = up;
            this.down = down;
        }
    }

    /**
     * @param root: the root of binary tree
     * @return: the length of the len consecutive sequence path
     */
    public int longestConsecutive2(TreeNode root) {
        return longestConsecutive(root).len;
    }

    private ResultType longestConsecutive(TreeNode root) {
        if(root==null) {
            return new ResultType(0, 0, 0);
        }

        ResultType left = longestConsecutive(root.left);
        ResultType right = longestConsecutive(root.right);
        int up = 0;
        int down = 0;

        if(root.left!=null) {
            if(root.val-root.left.val==1) {
                down = Math.max(down, left.down +1);
            } else if(root.val-root.left.val==-1) {
                up = Math.max(up, left.up +1);
            }
        }

        if(root.right!=null) {
            if(root.val-root.right.val==1) {
                down = Math.max(down, right.down +1);
            } else if(root.val-root.right.val==-1) {
                up = Math.max(up, right.up +1);
            }
        }

        int len = up+down+1;
        len = Math.max(len, Math.max(left.len, right.len));

        return new ResultType(len, up, down);
    }
}
