package ninechapter.tree.optional;

import datastructures.TreeNode;

public class SubtreeWithMaximumAverage {

    class ResultType {
        public int sum;
        public TreeNode root;
        public double maxAvg;
        public int cnt;

        public ResultType(TreeNode root, int sum, int cnt, double maxAvg) {
            this.root = root;
            this.sum = sum;
            this.cnt = cnt;
            this.maxAvg = maxAvg;
        }
    }

    public TreeNode findSubtree2(TreeNode root) {
        return findSubtree(root).root;
    }

    private ResultType findSubtree(TreeNode root) {
        if(root==null) {
            return new ResultType(null, 0, 0, 0);
        }

        ResultType left = findSubtree(root.left);
        ResultType right = findSubtree(root.right);

        int sum = left.sum+right.sum+root.val;
        int cnt = left.cnt+right.cnt+1;
        double avg = (double)sum/cnt;

        TreeNode ans = root;

        if(left.root!=null) {
            ans = avg>left.maxAvg? ans: left.root;
            avg = Math.max(avg, left.maxAvg);
        }

        if(right.root!=null) {
            ans = avg>right.maxAvg? ans: right.root;
            avg = Math.max(avg, right.maxAvg);
        }

        return new ResultType(ans, sum, cnt, avg);
    }
}
