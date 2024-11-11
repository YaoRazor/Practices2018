package ninechapter.tree.optional;


import java.util.LinkedList;
import java.util.Queue;

import datastructures.TreeNode;

public class MaximumDepthOfBinaryTree {

    public int maxDepthDFS(TreeNode root) {
        if(root==null) {
            return 0;
        }

        int left = maxDepthDFS(root.left);
        int right = maxDepthDFS(root.right);

        return Math.max(left, right)+1;
    }

    public int maxDepthBFS(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        int size = 1;
        int depth =0;

        while (queue.size() > 0) {
            while (size>0) {
                TreeNode cur = queue.poll();

                if(cur.left != null) {
                    queue.offer(cur.left);
                }

                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                size --;
            }
            depth++;
            size = queue.size();
        }

        return depth;
    }
}
