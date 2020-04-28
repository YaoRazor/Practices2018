package ninechapter.dfs.required;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Do BFS to get distance map from end to start, this map
// is used for pruning by validity Run DFS to get all shortest distance
public class WordLadderTwo {

    Map<String, Set<String>> index;

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> ans = new ArrayList<>();
        if(start==null || start.length()==0 || end==null || end.length()==0) {
            return ans;
        }

        LinkedList<String> cur = new LinkedList<>();
        cur.add(start);
        dict.add(start);
        dict.add(end);
        index = buildIndex(dict);
        Map<String, Integer> map = bfs(end, start, dict);
        dfs(ans, start, end, map, cur, dict);

        return ans;
    }


    private void dfs(List<List<String>> ans, String start, String end, Map<String, Integer> map, LinkedList<String> cur,Set<String> dict) {
        if(start.equals(end)) {
            ans.add(new LinkedList<>(cur));
            return;
        }

        Set<String> neighbors = getNextStrings(start, index);

        for(String tmp: neighbors) {
            System.out.println("tmp is "+tmp+" start is "+start+" start distance is "+map.get(start));
            if(map.get(tmp)>=map.get(start)) {
                continue;
            }

            cur.add(tmp);
            dfs(ans, tmp, end, map, cur, dict);
            cur.removeLast();
        }
    }

    private Map<String, Integer> bfs(String start, String end, Set<String> dict) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        queue.offer(start);
        visited.add(start);
        int distance = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                String cur = queue.poll();
                map.put(cur, distance);
                Set<String> neighbors = getNextStrings(cur, index);

                for(String tmp: neighbors) {
                    if(visited.contains(tmp)) {
                        continue;
                    }

                    queue.offer(tmp);
                    visited.add(tmp);
                }
            }

            distance++;
        }

        return map;
    }


    private Map<String, Set<String>> buildIndex(Set<String> dict) {
        Map<String, Set<String>> map = new HashMap<>();
        for(String cur: dict) {
            for(int i=0; i<cur.length(); i++) {
                String key;

                if(i==0) {
                    key = '?'+cur.substring(i+1);
                } else {
                    key = cur.substring(0, i)+'?'+cur.substring(i+1);
                }

                if(map.containsKey(key)) {
                    map.get(key).add(cur);
                } else {
                    Set<String> set = new HashSet<>();
                    set.add(cur);
                    map.put(key, set);
                }
            }


        }

        return map;
    }


    private Set<String> getNextStrings(String cur, Map<String, Set<String>> index) {
        Set<String> ans = new HashSet<>();

        for(int i=0; i<cur.length(); i++) {
            String key;

            if(i==0) {
                key = '?'+cur.substring(i+1);
            } else {
                key = cur.substring(0, i)+'?'+cur.substring(i+1);
            }

            ans.addAll(index.get(key));
        }

        ans.remove(cur);
        return ans;
    }
}
