package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructures.TreeNode;


public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();

        if(root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int size = 1;


        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int count = 0;

            for(int i=0; i< size; i++) {
                TreeNode cur = queue.poll();

                tmp.add(cur.val);

                if(cur.left != null) {
                    queue.add(cur.left);
                    count++;
                }

                if(cur.right != null) {
                    queue.add(cur.right);
                    count++;
                }

            }
            ret.add(tmp);
            size = count;
        }

        return ret;
    }
}
