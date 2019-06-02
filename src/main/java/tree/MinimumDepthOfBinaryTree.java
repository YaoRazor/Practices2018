package tree;

import java.util.LinkedList;
import java.util.Queue;

import datastructures.TreeNode;


public class MinimumDepthOfBinaryTree {
    // You have to reach a leaf node to claim a valid depth of the tree
    public int minDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }

        if(root.left==null && root.right==null) {
            return 1;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if(root.left!=null) {
            left = minDepth(root.left);
        }

        if(root.right!=null) {
            right = minDepth(root.right);
        }

        return Math.min(left, right)+1;
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
