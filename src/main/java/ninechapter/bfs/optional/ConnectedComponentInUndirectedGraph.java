package ninechapter.bfs.optional;

import datastructures.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.*;

public class ConnectedComponentInUndirectedGraph {
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nodes==null || nodes.size()==0) {
            return ans;
        }

        Set<UndirectedGraphNode> visited = new HashSet<>();

        for(UndirectedGraphNode node: nodes) {
            bfs(node, visited, ans);
        }

        return ans;
    }


    private void bfs(UndirectedGraphNode cur, Set<UndirectedGraphNode> visited, List<List<Integer>> ans) {
        if(visited.contains(cur)) {
            return;
        }

        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.offer(cur);
        visited.add(cur);

        List<Integer> tmp = new ArrayList<>();

        while(!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();
            tmp.add(node.label);

            for(UndirectedGraphNode neighbor: node.neighbors) {
                if(!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }

        }

        Collections.sort(tmp);

        ans.add(tmp);
    }
}
