package ninechapter.bfs.topological_sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumHeightTrees {

    // The key idea is to start to leave node which can be
    // determined by indegree from which we can see that graph
    // node with smaller indegree nodes are less important
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if(n==1) {
            leaves.add(0);
            return leaves;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for(int i=0; i<n; i++) {
            graph.put(i, new HashSet<>());
            indegree.put(i, 0);
        }

        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            indegree.put(edge[0], indegree.get(edge[0])+1);
            indegree.put(edge[1], indegree.get(edge[1])+1);
        }


        for(int i=0; i<n; i++) {
            if(indegree.get(i)==1) {
                leaves.add(i);
            }
        }

        while(n>2) {
            n-=leaves.size();
            List<Integer> cur = new ArrayList<>();

            for(int i: leaves) {
                for(int to: graph.get(i)) {
                    indegree.put(to, indegree.get(to)-1);
                    graph.get(to).remove(i);
                    if(indegree.get(to)==1) {
                        cur.add(to);
                    }
                }
            }

            leaves = cur;
        }

        return leaves;
    }
}
