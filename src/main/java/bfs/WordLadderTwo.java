package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// 这题就背答案吧，别挣扎了
public class WordLadderTwo {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        List<List<String>> ans = new ArrayList<>();

        bfs(beginWord, endWord, dict, graph, distance);
        LinkedList<String> solution = new LinkedList<>();
        solution.add(beginWord);
        dfs(beginWord, endWord, dict, graph, distance, solution, ans);

        return ans;
    }


    private void dfs(String cur, String end, Set<String> dict, Map<String, Set<String>> graph, Map<String, Integer> distance, LinkedList<String> solution, List<List<String>> ans){
        if(cur.equals(end)) {
            ans.add(new LinkedList<>(solution));
            return;
        }

        for(String neighbor: graph.get(cur)) {
            if(distance.get(neighbor)==distance.get(cur)+1) {
                solution.add(neighbor);
                dfs(neighbor, end, dict, graph, distance, solution, ans);
                solution.removeLast();
            }
        }
    }


    private void bfs(String start, String end, Set<String> dict, Map<String, Set<String>> graph, Map<String, Integer> distance) {
        graph.put(start, new HashSet<>());
        for(String str: dict) {
            graph.put(str, new HashSet<>());
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        distance.put(start, 0);
        int curDistance = 0;

        boolean isFound = false;

        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int i=0; i<size; i++) {
                String cur = queue.poll();
                List<String> neighbors = getNeighbors(cur, dict);
                graph.get(cur).addAll(neighbors);

                for(String neighbor: neighbors) {
                    if(distance.containsKey(neighbor)) {
                        continue;
                    }

                    distance.put(neighbor, curDistance+1);

                    if(neighbor.equals(end)) {
                        isFound = true;
                    } else {
                        queue.offer(neighbor);
                    }
                }
            }

            if(isFound) {
                break;
            }

            curDistance++;
        }

    }



    private List<String> getNeighbors(String cur, Set<String> dict) {
        List<String> ans = new ArrayList<>();
        char[] charArray = cur.toCharArray();

        for(int i=0; i<charArray.length; i++) {
            for(char c='a'; c<='z'; c++) {
                if(c==charArray[i]) {
                    continue;
                }

                char old = charArray[i];
                charArray[i] = c;
                String tmp = new String(charArray);
                if(dict.contains(tmp)) {
                    ans.add(tmp);
                }
                charArray[i] = old;
            }

        }

        return ans;
    }
}
