package bst;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import datastructures.TreeNode;


public class TwoSumFour {

    public boolean findTarget(TreeNode root, int k) {

        if(root==null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Set<Integer> set = new HashSet<>();

        while (queue.size()>0) {
            TreeNode cur = queue.poll();

            if(set.contains(k-cur.val)) {
                return true;
            }

            set.add(cur.val);

            if(cur.left!=null) {
                queue.add(cur.left);
            }

            if(root.right!=null) {
                queue.add(cur.right);
            }

        }

        return false;
    }

}
