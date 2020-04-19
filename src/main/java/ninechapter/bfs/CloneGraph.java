package ninechapter.bfs;


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
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

    // For this problem, there can be a way of doing three steps at the same time, but
    // it is not intuitive and error prune. So we break it into three sub steps there
    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        if(node==null) {
            return null;
        }

        // get all nodes
        Set<UndirectedGraphNode> set = getAllNodes(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        // get mapping
        for(UndirectedGraphNode cur: set) {
            UndirectedGraphNode copyNode = new UndirectedGraphNode(cur.label);
            map.put(cur, copyNode);
        }

        // Clone topology
        for(UndirectedGraphNode cur: set) {
            UndirectedGraphNode copyNode = map.get(cur);
            for(UndirectedGraphNode neighbor: cur.neighbors) {
                copyNode.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    private Set<UndirectedGraphNode> getAllNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);

        while(!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for(UndirectedGraphNode neighbor: cur.neighbors) {
                if(!set.contains(neighbor)) {
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }

        return set;
    }
}
