package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import datastructures.TreeNode;


public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) {
            return ans;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                if(cur.left!=null) {
                    queue.offer(cur.left);
                }

                if(cur.right!=null) {
                    queue.offer(cur.right);
                }

                if(i==size-1) {
                    ans.add(cur.val);
                }
            }
        }

        return ans;
    }

    public List<Integer> rightSideViewRecursive(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) {
            return ans;
        }

        dfs(root, ans, 0);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans, int depth) {
        if(root==null) {
            return;
        }

        if(depth==ans.size()) {
            ans.add(root.val);
        }

        dfs(root.right, ans, depth+1);
        dfs(root.left, ans, depth+1);
    }
}
