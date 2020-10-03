package companies.apple;

import java.util.*;

public class SerializeAndDeserializeNaryTree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public String serialize(Node root) {
        if (root == null)   return null;
        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        sb.append(root.val);
        sb.append("#");
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node curr = queue.poll();
            List<Node> children = curr.children;
            if (children == null || children.size() == 0) {
                sb.append(" ");
            } else {
                for (Node c : children) {
                    sb.append(c.val);
                    sb.append(",");
                    queue.offer(c);
                }
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append("#");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null)   return null;
        Queue<Node> parents = new LinkedList<>();
        String[] elements = data.split("#");
        Node root = new Node(Integer.valueOf(elements[0]), new ArrayList<>());
        parents.offer(root);
        for (int i = 1; i < elements.length; i++) {
            Node parent = parents.poll();
            String[] kids = elements[i].split(",");
            for (String kid : kids) {
                if (kid.equals(" ")) break;
                Node k = new Node(Integer.valueOf(kid), new ArrayList<>());
                parent.children.add(k);
                parents.offer(k);
            }
        }
        return root;
    }
}
