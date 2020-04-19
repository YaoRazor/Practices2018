package ninechapter.bfs;

import ninechapter.DirectedGraphNode;

import java.util.*;

public class TopologicalSorting {

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        if(graph==null || graph.size()==0) {
            return res;
        }

        Map<DirectedGraphNode, Integer> map = new HashMap<>();

        for(DirectedGraphNode node: graph) {
            map.put(node, 0);
        }

        for(DirectedGraphNode node: graph) {
            for(DirectedGraphNode neighbor: node.neighbors) {
                map.put(neighbor, map.get(neighbor)+1);
            }
        }

        Queue<DirectedGraphNode> queue = new ArrayDeque();

        for(DirectedGraphNode node: map.keySet()) {
            if(map.get(node)==0) {
                queue.offer(node);
            }
        }

        while(!queue.isEmpty()) {
            DirectedGraphNode cur = queue.poll();
            res.add(cur);

            for(DirectedGraphNode neighbor: cur.neighbors) {
                map.put(neighbor, map.get(neighbor)-1);
                if(map.get(neighbor)==0) {
                    queue.offer(neighbor);
                }
            }

        }

        return res;
    }
}
