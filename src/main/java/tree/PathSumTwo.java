package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import datastructures.TreeNode;


public class PathSumTwo {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if(root==null) {
            return ans;
        }

        LinkedList<Integer> cur = new LinkedList<>();
        dfs(root, cur, sum);
        return ans;
    }



    public void dfs(TreeNode root, LinkedList<Integer> cur, int sum) {

        if(root.left==null && root.right==null) {
            if(sum-root.val==0) {
                cur.add(root.val);
                ans.add(new LinkedList<>(cur));
                cur.removeLast();
            }
        }

        cur.add(root.val);

        if(root.left!=null) {
            dfs(root.left, cur, sum-root.val);
        }

        if(root.right!=null) {
            dfs(root.right, cur,sum-root.val);
        }

        cur.removeLast();

    }
}
