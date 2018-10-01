package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {

        if((n-1)!=edges.length) {
            return false;
        }

        Map<Integer, Set<Integer>> nodes = getAllNodes(n, edges);

        Set<Integer> visited = new HashSet<>();
        Deque<Integer> deque = new ArrayDeque<>();
        visited.add(0);
        deque.addLast(0);

        while(!deque.isEmpty()) {
            Integer cur = deque.pollFirst();

            for(Integer i: nodes.get(cur)) {

                if(visited.contains(i)) {
                    continue;
                }

                deque.addLast(i);
                visited.add(i);
            }


        }

        return visited.size()==n;

    }


    private Map<Integer, Set<Integer>> getAllNodes(int n, int[][] edges) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) {

            map.put(i, new HashSet<>());
        }

        for(int i=0; i<edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            // Add twice here
            map.get(u).add(v);
            map.get(v).add(u);

        }

        return map;

    }
}
