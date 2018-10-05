package design;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import datastructures.TreeNode;

public class SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) {
            return "";
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            sb.append(cur.val);
            sb.append(",");

            if(cur.right!=null) {
                stack.push(cur.right);
            }

            if(cur.left!=null) {
                stack.push(cur.left);
            }
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data == null || data.isEmpty()) {
            return null;
        }

        String[] stringArray= data.split(",");
        List<Integer> list = Arrays.asList(stringArray).stream().
                map(d->Integer.parseInt(d)).collect(Collectors.toList());

        return buildTree(list);


    }

    private TreeNode buildTree(List<Integer> list) {

        if(list.isEmpty()) {
            return null;
        }


        TreeNode root = new TreeNode(list.get(0));
        int i=1;

        while(i<list.size()) {

            if(list.get(i)<root.val) {
                i++;
                continue;
            }
            break;
        }

        root.left = buildTree(list.subList(1, i));
        root.right = buildTree(list.subList(i, list.size()));

        return root;

    }
}
