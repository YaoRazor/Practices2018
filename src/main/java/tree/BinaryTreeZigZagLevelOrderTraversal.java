package tree;

import java.util.*;

import datastructures.TreeNode;


public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) {
            return ans;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 1;

        while(!queue.isEmpty()) {

            int size = queue.size();
            LinkedList<Integer> tmp = new LinkedList<>();

            for(int i=0; i<size; i++) {

                TreeNode cur = queue.poll();
                if(level%2==1) {
                    tmp.addLast(cur.val);
                } else {
                    tmp.addFirst(cur.val);
                }

                if(cur.left!=null) {
                    queue.offer(cur.left);
                }

                if(cur.right!=null) {
                    queue.offer(cur.right);
                }

            }

            level++;
            ans.add(tmp);
        }

        return ans;
    }
}
