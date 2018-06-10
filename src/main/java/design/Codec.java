package design;


import java.util.Arrays;
import java.util.LinkedList;

import datastructures.TreeNode;

public class Codec {
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        if(sb.length()>1) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();

    }


    private void dfs(TreeNode root, StringBuilder sb) {
        if(root==null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val+",");

        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data==null || data.length()==0) {
            return null;
        }

        LinkedList<String> listOfData = new LinkedList<>(Arrays.asList(data.split(",")));

        return dfsDeserialize(listOfData);

    }

    private TreeNode dfsDeserialize(LinkedList<String> data) {

        if(data.isEmpty()) {
            return null;
        }

        String cur = data.poll();

        if(cur.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(cur));

        root.left = dfsDeserialize(data);
        root.right = dfsDeserialize(data);
        return root;
    }
}
