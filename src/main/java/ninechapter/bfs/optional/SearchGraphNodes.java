package ninechapter.bfs.optional;

import datastructures.UndirectedGraphNode;

import java.util.*;

public class SearchGraphNodes {
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {

        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();

        queue.offer(node);
        visited.add(node);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                UndirectedGraphNode cur = queue.poll();
                if(values.get(cur)==target) {
                    return cur;
                }

                for(UndirectedGraphNode tmp: cur.neighbors) {

                    if(!visited.contains(tmp)) {
                        queue.offer(tmp);
                        visited.add(tmp);
                    }

                }
            }
        }

        return null;
    }
}
