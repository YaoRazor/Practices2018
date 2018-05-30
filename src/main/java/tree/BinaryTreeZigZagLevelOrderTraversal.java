package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import datastructures.TreeNode;

/**
 * Created by yawang on 5/20/18.
 */
public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if(root==null) {
            return ans;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int level = 0;
        int currentLevelSize = 1;

        while (!queue.isEmpty()) {
            int n = currentLevelSize;
            currentLevelSize = 0;
            LinkedList<Integer> curList = new LinkedList<>();

            for(int i=0; i<n; i++) {
                TreeNode cur = queue.poll();
                if(level%2==0) {
                    curList.add(cur.val);
                } else {
                    curList.addFirst(cur.val);
                }

                if(cur.left!=null) {
                    queue.add(cur.left);
                    currentLevelSize++;
                }


                if(cur.right!=null) {
                    queue.add(cur.right);
                    currentLevelSize++;
                }
            }

            ans.add(curList);
            level++;

        }

        return ans;
    }
}
