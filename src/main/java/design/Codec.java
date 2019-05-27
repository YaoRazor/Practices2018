package design;

import datastructures.TreeNode;

public class Codec {

    // Preorder traversal is very intuitive
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root==null) {
            return sb.toString();
        }
        buildTree(root, sb);
        // sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    private void buildTree(TreeNode root, StringBuilder sb) {
        if(root==null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val+",");
        buildTree(root.left, sb);
        buildTree(root.right, sb);
    }

    // We can also use deque to deque here
    int i=0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data==null || data.length()==0) {
            return null;
        }
        i = 0;
        String[] array = data.split(",");
        return buildTree(array);

    }

    private TreeNode buildTree(String[] array) {
        if(array[i].equals("null")) {
            i++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(array[i]));
        i++;
        root.left = buildTree(array);
        root.right = buildTree(array);
        return root;
    }
}
