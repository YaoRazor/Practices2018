package tree;

import java.util.ArrayList;
import java.util.List;

import datastructures.TreeNode;


public class BinaryTreePaths {
    public List<String> binaryTreePathsRecursion(TreeNode root) {

        List<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if(root != null) {
            dfs(root, sb, ret);
        }

        return ret;
    }


    private void dfs(TreeNode cur, StringBuilder sb, List<String> ret) {

        sb.append(cur.val);

        if(cur.left==null && cur.right == null) {
            ret.add(sb.toString());
            return;
        }
        sb.append("->");

        if(cur.left != null) {
            dfs(cur.left, new StringBuilder(sb), ret);
        }

        if(cur.right != null) {
            dfs(cur.right, new StringBuilder(sb), ret);
        }
    }


    public List<String> binaryTreePathsDivideAndConquer(TreeNode root) {

        List<String> ans = new ArrayList<>();
        if(root==null) {
            return ans;
        }

        if(root.left==null && root.right==null) {
            ans.add(String.valueOf(root.val));
            return ans;
        }

        List<String> left = binaryTreePathsDivideAndConquer(root.left);
        List<String> right = binaryTreePathsDivideAndConquer(root.right);

        for(String str: left) {
            ans.add(String.valueOf(root.val)+"->"+str);
        }

        for(String str: right) {
            ans.add(String.valueOf(root.val)+"->"+str);
        }

        return ans;
    }
}
