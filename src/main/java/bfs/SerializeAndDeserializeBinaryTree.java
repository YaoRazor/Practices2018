package bfs;

import java.util.ArrayDeque;
import java.util.Deque;

import datastructures.TreeNode;

public class SerializeAndDeserializeBinaryTree {

    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> deque = new ArrayDeque<>();

        if(root==null) {
            return sb.toString();
        }
        TreeNode cur = root;

        deque.addLast(cur);
        sb.append(cur.val + ",");

        while(!deque.isEmpty()) {

            cur = deque.pollFirst();

            if(cur.left!=null) {
                deque.addLast(cur.left);
                sb.append(cur.left.val + ",");
            } else {
                sb.append("null,");
            }

            if(cur.right!=null) {
                deque.addLast(cur.right);
                sb.append(cur.right.val + ",");
            } else {
                sb.append("null,");
            }

        }

        int length = sb.length();
        sb.deleteCharAt(length-1);

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data==null || data.length()==0) {
            return null;
        }

        String[] array = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(array[0]));

        // BFS is used to help track the parent nodes
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);


        for(int i=1; i<array.length; i++) {

            TreeNode parent = deque.pollFirst();

            // Every parent node will corresponds to two children nodes
            if(!array[i].equals("null")) {

                parent.left = new TreeNode(Integer.parseInt(array[i]));
                deque.addLast(parent.left);
            }

            if(!array[++i].equals("null")) {

                parent.right = new TreeNode(Integer.parseInt(array[i]));
                deque.addLast(parent.right);
            }

        }

        return root;
    }
}
