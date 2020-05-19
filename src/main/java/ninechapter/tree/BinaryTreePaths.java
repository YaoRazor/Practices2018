package ninechapter.tree;

import java.util.ArrayList;
import java.util.List;

import datastructures.TreeNode;


public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        traverseTree(root, "", ans);
        return ans;
    }

    private void traverseTree(TreeNode root, String cur, List<String> ans) {
        if(root==null) {
            return;
        }

        if(cur.length()==0) {
            cur = String.valueOf(root.val);
        } else {
            cur = cur+ "->"+ root.val;
        }

        if(root.left==null && root.right==null) {
            ans.add(cur);
            return;
        }

        traverseTree(root.left, cur, ans);
        traverseTree(root.right, cur, ans);
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
