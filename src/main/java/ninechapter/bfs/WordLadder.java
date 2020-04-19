package ninechapter.bfs;;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    private Set<String> getAllString(String start, Set<String> dict, Set<String> visited) {
        Set<String> res = new HashSet<>();

        for (int i = 0; i < start.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char tmp = (char) ('a' + j);
                String cur = start.substring(0, i) + tmp + start.substring(i + 1);
                if (dict.contains(cur) && !visited.contains(cur)) {
                    res.add(cur);
                }
            }
        }

        return res;
    }


    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        dict.add(end); // Ideally we should not modify the input object

        queue.offer(start);
        visited.add(start);
        int distance = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(end)) {
                    return distance;
                }

                Set<String> next = getAllString(cur, dict, visited);

                for (String tmp : next) {
                    queue.offer(tmp);
                    visited.add(tmp);
                }
            }

            distance++;
        }

        return 0;
    }

}
