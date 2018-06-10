package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructures.TreeNode;


public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if(root==null) {
            return ans;
        }


        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLevelSize = 1;

        while (!queue.isEmpty()) {


            for(int i=0; i<currentLevelSize; i++) {

                TreeNode cur = queue.poll();

                if(cur.left!=null) {
                    queue.add(cur.left);
                }

                if(cur.right!=null) {
                    queue.add(cur.right);
                }


                if(i==currentLevelSize-1) {
                    ans.add(cur.val);
                }

            }

            currentLevelSize = queue.size();
        }

        return ans;
    }

    public List<Integer> rightSideViewRecursive(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if(root==null) {
            return ans;
        }

        dfs(root, ans, 1);

        return ans;
    }


    private void dfs(TreeNode root, List<Integer> ans, int depth) {

        if(root==null) {
            return;
        }

        if(depth>ans.size()) {
            ans.add(root.val);
        }

        dfs(root.right, ans, depth+1);
        dfs(root.right, ans, depth+1);

    }
}
