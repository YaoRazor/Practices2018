package ninechapter.tree.optional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import datastructures.TreeNode;


public class BinaryPathSum {

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) {
            return ans;
        }
        LinkedList<Integer> cur = new LinkedList<>();
        dfs(ans, cur, root, target);
        return ans;
    }


    private void dfs(List<List<Integer>> ans, LinkedList<Integer> cur, TreeNode root, int target) {
        cur.add(root.val);
        if(root.left==null && root.right==null) {
            if(root.val==target) {
                ans.add(new LinkedList<>(cur));
            }
            cur.removeLast();
            return;
        }

        if(root.left!=null) {
            dfs(ans, cur, root.left, target-root.val);
        }

        if(root.right!=null) {
            dfs(ans, cur, root.right, target-root.val);
        }

        cur.removeLast();
    }
}
