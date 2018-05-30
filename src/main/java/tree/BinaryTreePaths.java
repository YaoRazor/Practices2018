package tree;

import java.util.ArrayList;
import java.util.List;

import datastructures.TreeNode;

/**
 * Created by yawang on 3/11/18.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {

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
}
