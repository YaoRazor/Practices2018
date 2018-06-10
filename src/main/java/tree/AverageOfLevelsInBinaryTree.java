package tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructures.TreeNode;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> ans = new ArrayList<>();

        if(root==null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            double sum = 0;
            int level = queue.size();
            for(int i=0; i<level; i++) {

                TreeNode cur = queue.poll();
                sum+=cur.val;

                if(cur.left!=null) {
                    queue.add(cur.left);
                }

                if(cur.right!=null) {
                    queue.add(cur.right);
                }

            }

            ans.add(sum/level);
        }

        return ans;
    }
}
