package ninechapter.bfs;;

import java.util.LinkedList;
import java.util.Queue;

import datastructures.TreeNode;

public class SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root==null) {
            return sb.toString();
        }

        // We have to use LinkedList here because LinkedList supports null value
        // while Deque does not
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // One of the key thing here is that null also needs to be
        // added to the queue. Just check the test case of this
        // class to have a better understanding here
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

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0) {
            return null;
        }

        String[] treeStr = data.split(",");
        TreeNode root = buildTreeNode(treeStr[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;

        while(!queue.isEmpty()) {
            // One valid node will correspond to two nodes
            // however those two nodes can be null nodes.
            TreeNode cur = queue.poll();

            TreeNode left = buildTreeNode(treeStr[index]);
            cur.left = left;
            // Only add to the queue when the node is not null,
            // this is different with how we serialize the tree
            if(left!=null) {
                queue.offer(left);
            }
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
