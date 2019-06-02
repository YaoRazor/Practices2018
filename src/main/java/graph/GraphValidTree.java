package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphValidTree {
    // BFS解法
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


    // DFS解法, 二个条件: 1. 全联通，2，无环
    public boolean validTreeDFS(int n, int[][] edges) {

        Map<Integer, Set<Integer>> map = getAllNodes(n, edges);

        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        // 检查是否有环
        if(hasCycle(map, visited, 0, -1)) {
            return false;
        }

        // 检查是否全联通
        return visited.size()==n;

    }

    // 一般情况下DFS是不需要parent节点的，因为结果都记录在map里，直接从里面取就行了，但是本题因为依赖于
    // 是否从前访问这个条件来检查环，对于DFS而言，只要不从子节点主动向父节点访问，那么就没有环的问题
    private boolean hasCycle(Map<Integer, Set<Integer>> map, Set<Integer> visited, int node, int parent) {

        for(Integer i: map.get(node)) {

            if(i==parent) {
                continue;
            }

            if(visited.contains(i)) {
                return true;
            }

            visited.add(i);

            if(hasCycle(map, visited, i, node)) {
                return true;
            }

        }

        return false;

    }


    // Union find 解法
    public boolean validTreeUF(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);

            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;

            // union
            nums[x] = y;
        }

        return edges.length == n - 1;
    }

    int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }

}
