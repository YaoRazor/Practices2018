package ninechapter.tree.optional;

import datastructures.TreeNode;

import java.util.*;

public class BinaryPathSumTwo {

    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        dfs(ans, cur, target, 0, root);
        return ans;
    }

    // The key to this problem is to find out the solutions ending in current node intead of
    // starting from this node which are commonly seen in traditional problems
    private void dfs(List<List<Integer>> ans, LinkedList<Integer> cur, int target, int level, TreeNode root) {
        if(root==null) {
            return;
        }
        cur.add(root.val);

        int sum = target;
        for(int i=level; i>=0; i--) {
            sum-=cur.get(i);
            if(sum==0) {
                List<Integer> tmp = new ArrayList<>();
                for(int j=i; j<=level;j++) {
                    tmp.add(cur.get(j));
                }
                ans.add(tmp);
            }
        }

        dfs(ans, cur, target, level+1, root.left);
        dfs(ans, cur, target, level+1, root.right);
        cur.removeLast();
    }
}
