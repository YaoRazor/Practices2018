package ninechapter.tree.related;

import java.util.List;

public class BinaryTreeLongestConsecutiveSequenceThree {

    public class MultiTreeNode {
        int val;
        List<MultiTreeNode> children;
        MultiTreeNode(int x) { val = x; }
    }

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


    public int longestConsecutive3(MultiTreeNode root) {
        return longestConsecutive(root).len;
    }

    private ResultType longestConsecutive(MultiTreeNode root) {
        if(root==null) {
            return new ResultType(0, 0, 0);
        }

        int up = 0;
        int down = 0;
        int len = 1;

        for(MultiTreeNode child: root.children) {
            if(child==null) {
                continue;
            }
            ResultType cur = longestConsecutive(child);

            if(root.val-child.val==1) {
                down = Math.max(down, cur.down +1);
            } else if(root.val-child.val==-1) {
                up = Math.max(up, cur.up +1);
            }

            len = Math.max(len, up+down+1);
            len = Math.max(len, cur.len);

        }

        return new ResultType(len, up, down);
    }
}
