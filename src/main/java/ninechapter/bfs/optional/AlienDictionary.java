package ninechapter.bfs.optional;

import java.util.*;

public class AlienDictionary {

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // trick one: initialize the graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String from = words[i];
            String to = words[i + 1];

            // trick two remove invalid dictionary order, this is
            // required by the problem
            if (from.length() > to.length() && from.startsWith(to)) {
                return "";
            }

            for (int j = 0; j < from.length() && j < to.length(); j++) {
                char p = from.charAt(j);
                char c = to.charAt(j);
                if (p == c) {
                    continue;
                }

                // avoid double counting
                if (!graph.get(p).contains(c)) {
                    graph.get(p).add(c);
                    indegree.put(c, indegree.get(c) + 1);
                }

                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new ArrayDeque<>();

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char cur = queue.poll();
            sb.append(cur);

            for (char neighbor : graph.get(cur)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // last trick: make sure that topologic sorting is valid
        if (sb.length() == indegree.size()) {
            return sb.toString();
        } else {
            return "";
        }
    }
}
