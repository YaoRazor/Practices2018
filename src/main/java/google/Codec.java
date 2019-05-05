package google;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Codec {
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        if(root==null) {
            return sb.toString();
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        sb.append(root.val+",");

        while(!deque.isEmpty()) {
            TreeNode cur = deque.pollFirst();

            if(cur.left!=null) {
                deque.addLast(cur.left);
                sb.append(cur.left.val+",");
            } else {
                sb.append("null,");
            }

            if(cur.right!=null) {
                deque.addLast(cur.right);
                sb.append(cur.right.val+",");
            } else {
                sb.append("null,");
            }
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();

    }

    public TreeNode deserialize(String data) {
        if("".equals(data)) {
            return null;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();


        String[] array = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        deque.addLast(root);

        for(int i=1; i<array.length; i++) {

            TreeNode parent = deque.pollFirst();

            if(! "null".equals(array[i])) {
                parent.left = new TreeNode(Integer.parseInt(array[i]));
                deque.addLast(parent.left);

            }

            if(! "null".equals(array[++i])) {
                parent.right = new TreeNode(Integer.parseInt(array[i]));
                deque.addLast(parent.right);

            }

        }

        return root;

    }
}
