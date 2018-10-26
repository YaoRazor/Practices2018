package graph;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import datastructures.UndirectedGraphNode;

public class CloneGraph {


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



    private UndirectedGraphNode cloneBFS(UndirectedGraphNode node){
        if(node==null) {
            return node;
        }

        Deque<UndirectedGraphNode> deque = new ArrayDeque<>();

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode copyOfNode = new UndirectedGraphNode(node.label);
        map.put(node, copyOfNode);

        deque.addLast(node);

        while(!deque.isEmpty()) {

            // Before you put it into the queue, you already created its copy
            UndirectedGraphNode cur = deque.pollFirst();
            UndirectedGraphNode copy = map.get(cur);

            for(UndirectedGraphNode child: cur.neighbors) {

                if(!map.containsKey(child)) {
                    UndirectedGraphNode copyOfChild = new UndirectedGraphNode(child.label);
                    map.put(child, copyOfChild);
                    deque.addLast(child);
                }

                copy.neighbors.add(map.get(child));

            }

        }

        return map.get(node);


    }
}
