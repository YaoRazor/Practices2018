package ninechapter.bfs.optional;

import java.util.*;

import datastructures.TreeNode;


public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            int size = queue.size();
            int level = ans.size();

            for(int i=0; i< size; i++) {
                TreeNode cur = queue.poll();

                if(level%2==0) {
                    tmp.add(cur.val);
                } else {
                    tmp.addFirst(cur.val);
                }

                if(cur.left != null) {
                    queue.add(cur.left);
                }

                if(cur.right != null) {
                    queue.add(cur.right);
                }

            }
            ans.add(tmp);
        }

        return ans;
    }
}
