package ninechapter.bfs;;

import java.util.LinkedList;
import java.util.Queue;

import datastructures.TreeNode;

// Use BFS in both serialization and deserialization
public class SerializeAndDeserializeBinaryTree {

    // root is null will also be handled by this implementation
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        // We have to use LinkedList here because LinkedList supports null value
        // while Deque does not
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Null needs to be added to the queue
        // for serialization
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur==null) {
                sb.append("#,");
            } else {
                sb.append(cur.val+",");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // In deserialization, null won't get into the queue
    public TreeNode deserialize(String data) {
        String[] treeStr = data.split(",");
        TreeNode root = buildTreeNode(treeStr[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            TreeNode left = buildTreeNode(treeStr[index]);
            cur.left = left;
            // Only add to the queue when the node is not null,
            // this is different with how we serialize the tree
            if(left!=null) {
                queue.offer(left);
            }
            // index++ is key in the deserialization process
            index++;

            TreeNode right = buildTreeNode(treeStr[index]);
            cur.right = right;
            if(right!=null) {
                queue.offer(right);
            }
            index++;
        }

        return root;
    }

    private TreeNode buildTreeNode(String str) {
        if("#".equals(str)) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(str));
        }
    }
}
