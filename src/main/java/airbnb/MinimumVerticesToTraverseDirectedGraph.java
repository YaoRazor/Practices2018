package airbnb;

import java.util.*;

public class MinimumVerticesToTraverseDirectedGraph {

    public List<Integer> getMin(int[][] edges, int n) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> ans = new HashSet<>();

        for(int i=0; i<n; i++) {
            map.put(i, new HashSet<>());
        }

        for(int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
        }


        Set<Integer> visited = new HashSet<>();

        for(int i=0; i<n; i++) {

            if(!visited.contains(i)) {
                ans.add(i);
                dfs(ans, visited, map, i, i, new HashSet<>());
            }

        }

        return new ArrayList<>(ans);

    }


    private void dfs(Set<Integer> ans, Set<Integer> visited, Map<Integer, Set<Integer>> map, int cur, int start, Set<Integer> curVisited) {

        visited.add(cur);
        curVisited.add(cur);

        if(map.containsKey(cur)) {

            for(int next: map.get(cur)) {

                // 这里是如果ans里包含next, 而且next不是这次搜索的发起点就从ans里移除
                if(ans.contains(next) && next!=start) {
                    ans.remove(next);
                    continue;
                }

                if(!curVisited.contains(next)) {
                    dfs(ans, visited, map, next, start, curVisited);
                }

            }
        }


    }


}
