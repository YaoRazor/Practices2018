package tree;


import java.util.HashMap;

import datastructures.TreeNode;

public class PathSum3 {

    public int pathSum(TreeNode root, int sum) {
        if(root==null) {
            return 0;
        }

        return  dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int dfs(TreeNode root, int sum) {

        if(root==null) {
            return 0;
        }

        int cnt = 0;

        if(root.val==sum) {
            cnt++;
        }

        cnt+=dfs(root.left, sum-root.val);
        cnt+=dfs(root.right, sum-root.val);

        return cnt;
    }

    public int pathSumTwo(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        return helper(root, 0, sum, preSum);

    }


    private int helper(TreeNode root, int curSum, int target, HashMap<Integer, Integer> map) {

        if(root==null) {
            return 0;
        }


        curSum+=root.val;

        int ans = map.getOrDefault(curSum-target, 0);

        map.put(curSum, map.getOrDefault(curSum, 0)+1);

        ans+= helper(root.left, curSum, target, map);
        ans+= helper(root.right, curSum, target, map);

        map.put(curSum, map.get(curSum)-1);
        return ans;

    }

}
