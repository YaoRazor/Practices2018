package ninechapter.bfs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };

    // DFS解法，DFS当然会有重复子问题，对于重复子问题，进行记忆就可以了
    public Node cloneGraphDFS(Node node) {
        return clone(node, new HashMap<>());
    }
    private Node clone(Node src, HashMap<Node, Node> map) {
        if(src == null) {
            return null;
        }

        if(map.containsKey(src)) {
            return map.get(src);
        }

        Node cur = new Node(src.val);
        // This has to be put before neighbors loop because
        // If a node has itself as neighbor, put it in the last will result infinite loop
        map.put(src, cur);

        for(Node neighbor: src.neighbors) {
            cur.neighbors.add(clone(neighbor, map));
        }

        return cur;
    }

    // We can clone and BFS at the same time, in this solution.
    // Basically Map serves as both the mapping and dedup
    public Node cloneGraph(Node node) {
            if(node==null) {
                return null;
            }
            Map<Node, Node> map = new HashMap<>();
            Queue<Node> queue = new ArrayDeque<>();

            queue.offer(node);
            map.put(node, new Node(node.val));

            while(!queue.isEmpty()) {
                Node cur = queue.poll();

                for(Node neighbor: cur.neighbors) {
                    if(!map.containsKey(neighbor)) {
                        map.put(neighbor, new Node(neighbor.val));
                        queue.offer(neighbor);
                    }

                    map.get(cur).neighbors.add(map.get(neighbor));
                }
            }

            return map.get(node);
        }
}
