package ninechapter.bfs.optional;

import datastructures.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalTwo {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ret = new LinkedList<>();

        if(root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);


        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();

            for(int i=0; i< size; i++) {
                TreeNode cur = queue.poll();

                tmp.add(cur.val);

                if(cur.left != null) {
                    queue.add(cur.left);
                }

                if(cur.right != null) {
                    queue.add(cur.right);
                }

            }
            ret.addFirst(tmp);
        }

        return ret;   // write your code here
    }
}
