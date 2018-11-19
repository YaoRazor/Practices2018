package linkedin;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {

    // 本题的关键点是树的高度是此点在树中的index
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        getHight(root, ans);
        return ans;

    }

    private int getHight(TreeNode node, List<List<Integer>> ans) {
        if(node==null) {
            return -1;
        }

        int level = 1 + Math.max(getHight(node.left, ans), getHight(node.right, ans));

        if(ans.size() < level+1) {
            ans.add(new ArrayList<>());
        }

        ans.get(level).add(node.val);
        return level;
    }
}
