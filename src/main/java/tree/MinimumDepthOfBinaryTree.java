package tree;

import java.util.LinkedList;
import java.util.Queue;

import datastructures.TreeNode;

/**
 * Created by yawang on 4/15/18.
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {

        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;

    }


    public int minDepthBFS(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList();

        queue.add(root);
        int size = 1;
        int depth =1;

        while (queue.size() > 0) {

            while (size>0) {
                TreeNode cur = queue.poll();
                if(cur.left == null && cur.right == null) {
                    return depth ;
                }

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
