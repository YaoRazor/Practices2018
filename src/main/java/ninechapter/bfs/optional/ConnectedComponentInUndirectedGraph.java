package ninechapter.bfs.optional;

import datastructures.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

// typical union find problem
public class ConnectedComponentInUndirectedGraph {

    Map<Integer, Integer> map = new HashMap<>();

    private int findFather(int x) {
        while(map.get(x)!=x) {
            x = map.get(x);
        }

        return x;
    }


    public List<List<Integer>> connectedSetUsingUnionFind(List<UndirectedGraphNode> nodes) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nodes==null || nodes.size()==0) {
            return ans;
        }

        // System.out.println("nodes size is: " + nodes.size());

        for(UndirectedGraphNode node: nodes) {
            // System.out.println("current node is: " + node.label);
            if(!map.containsKey(node.label)) {
                map.put(node.label, node.label);
            }


            for(UndirectedGraphNode neighbor: node.neighbors) {
                if(!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, neighbor.label);
                }
                int father = findFather(node.label);
                int neighborFather = findFather(neighbor.label);

                if(neighborFather!=father) {
                    map.put(neighborFather, father);
                }

            }
        }


        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(Integer tmp: map.keySet()) {
            int father = findFather(tmp);

            if(!graph.containsKey(father)) {
                graph.put(father, new ArrayList<>());
            }

            graph.get(father).add(tmp);
        }

        for(Integer tmp: graph.keySet()) {
            List<Integer> list = graph.get(tmp);
            Collections.sort(list);
            ans.add(list);
        }

        return ans;
    }
}
