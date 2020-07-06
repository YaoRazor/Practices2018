package ninechapter.tree.related;

import datastructures.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {

    int ans = 0;
    public int longestConsecutive(TreeNode root) {
        if(root==null) {
            return 0;
        }

        dfs(root.left, 1, root.val);
        // dfs(root.right, 1, root.val);
        return ans;
    }

    private void dfs(TreeNode root, int curLength, int parent) {
        ans = Math.max(curLength, ans);
        if(root==null) {
            return;
        }

        if(parent+1==root.val) {
            dfs(root.left, curLength+1, root.val);
            dfs(root.right, curLength+1, root.val);
        } else {
            dfs(root.left, 1, root.val);
            dfs(root.right, 1, root.val);
        }
    }

}
