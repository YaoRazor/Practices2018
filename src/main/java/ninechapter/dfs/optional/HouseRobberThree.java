package ninechapter.dfs.optional;

import datastructures.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberThree {

    // Although it is under dfs, but we can actually solve this problem
    // using memorization search
    public int houseRobber3(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return houseRobber(root, map);
    }

    private int houseRobber(TreeNode root, Map<TreeNode, Integer> map) {
        if(root==null) {
            return 0;
        } else if(map.containsKey(root)) {
            return map.get(root);
        }

        int sumWithoutRoot = 0;
        sumWithoutRoot +=houseRobber(root.left, map);
        sumWithoutRoot +=houseRobber(root.right, map);

        int sumWithRoot = root.val;

        if(root.left!=null) {
            sumWithRoot+=houseRobber(root.left.left, map);
            sumWithRoot+=houseRobber(root.left.right, map);
        }

        if(root.right!=null) {

            sumWithRoot+=houseRobber(root.right.left, map);
            sumWithRoot+=houseRobber(root.right.right, map);
        }

        map.put(root, Math.max(sumWithRoot, sumWithoutRoot));
        return map.get(root);
    }
}
