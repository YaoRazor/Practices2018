package bfs;

import java.util.ArrayDeque;
import java.util.Deque;

import datastructures.TreeNode;

public class SerializeAndDeserializeBinaryTree {

    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(root==null)  {
            sb.append("]");
            return sb.toString();
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        sb.append(root.val+ ",");

        while (!deque.isEmpty()) {

            TreeNode cur = deque.pollFirst();

            if(cur.left!=null) {
                deque.addLast(cur.left);
                sb.append(cur.left.val+ ",");
            } else {
                sb.append("n" + ",");
            }

            if(cur.right!=null) {
                deque.addLast(cur.right);
                sb.append(cur.right.val+ ",");
            }else {
                sb.append("n" + ",");
            }

        }

        sb.deleteCharAt(sb.length()-1);

        sb.append("]");

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        data = data.substring(1, data.length()-1);
        if(data.equals("")) {
            return null;
        }

        String[] nodeArray = data.split(",");

        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodeArray[0]));
        deque.addLast(root);


        for(int i=1; i<nodeArray.length; i++) {

            TreeNode parent = deque.pollFirst();

            if(!nodeArray[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodeArray[i]));
                parent.left = left;
                deque.addLast(left);
            }


            if(!nodeArray[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodeArray[i]));
                parent.right = right;
                deque.addLast(right);
            }

        }

        return root;
    }
}
