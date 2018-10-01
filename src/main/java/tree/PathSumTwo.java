package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import datastructures.TreeNode;


public class PathSumTwo {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        LinkedList<Integer> cur = new LinkedList<>();
        dfs(root, sum, cur);
        return ans;

    }


    private void dfs(TreeNode root, int sum, LinkedList<Integer> cur) {

        if(root==null) {
            return;
        }
        cur.add(root.val);

        if(root.left==null && root.right==null) {
            if(root.val==sum) {
                ans.add(new LinkedList<>(cur));

            }
            cur.removeLast();

            return;
        }

        dfs(root.left, sum-root.val, cur);
        dfs(root.right, sum-root.val, cur);
        cur.removeLast();

    }
}
