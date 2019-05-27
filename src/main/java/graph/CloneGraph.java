package graph;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import datastructures.UndirectedGraphNode;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };

    // DFS解法，DFS当然会有重复子问题，对于重复子问题，进行记忆就可以了
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node, new HashMap<>());
    }
    private UndirectedGraphNode clone(UndirectedGraphNode src, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        if(src == null) {
            return null;
        }

        if(map.containsKey(src)) {
            return map.get(src);
        }

        UndirectedGraphNode cur = new UndirectedGraphNode(src.label);
        // This has to be put before neighbors loop because
        // If a node has itself as neighbor, put it in the last will result infinite loop
        map.put(src, cur);

        for(UndirectedGraphNode neighboor: src.neighbors) {
            cur.neighbors.add(clone(neighboor, map));
        }

        return cur;
    }

    private Node cloneBFS(Node node){
        if(node==null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val, new ArrayList<>()));

        Set<Node> visited = new HashSet<>();
        Deque<Node> queue = new ArrayDeque<>();

        queue.offer(node);
        visited.add(node);

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for(Node neighbor: cur.neighbors) {

                Node copy = map.getOrDefault(neighbor, new Node(neighbor.val, new ArrayList<>()));
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, copy);
                }

                map.get(cur).neighbors.add(copy);

                if(!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return map.get(node);
    }
}
