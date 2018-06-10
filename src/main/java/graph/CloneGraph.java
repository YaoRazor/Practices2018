package graph;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import datastructures.UndirectedGraphNode;

public class CloneGraph {



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


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node, new HashMap<>());
    }

    private UndirectedGraphNode cloneBFS(UndirectedGraphNode src){
        if (src == null){
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        queue.add(src);

        while (!queue.isEmpty()) {

            UndirectedGraphNode cur = queue.poll();
            UndirectedGraphNode copy;

            if(map.containsKey(cur)) {
                copy = map.get(cur);
            } else {
                copy = new UndirectedGraphNode(cur.label);
                map.put(cur, copy);
            }

            for(UndirectedGraphNode child: cur.neighbors) {

                if(map.containsKey(child)) {
                    copy.neighbors.add(map.get(child));
                } else {
                    UndirectedGraphNode childCopy = new UndirectedGraphNode(child.label);
                    copy.neighbors.add(childCopy);
                    map.put(child, childCopy);

                    // Only add unvisited node in the queue to avoid loop
                    queue.add(child);
                }


            }

        }

        return map.get(src);


    }
}
