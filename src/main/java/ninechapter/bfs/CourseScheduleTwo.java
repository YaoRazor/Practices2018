package ninechapter.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleTwo {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Set<Integer>> edges = new HashMap<>();

        for(int[] prerequisite: prerequisites) {
            if(edges.containsKey(prerequisite[1]) && edges.get(prerequisite[1]).contains(prerequisite[0]))  {
                continue;
            }

            inDegree.put(prerequisite[0], inDegree.getOrDefault(prerequisite[0], 0)+1);

            if(edges.containsKey(prerequisite[1])) {
                edges.get(prerequisite[1]).add(prerequisite[0]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(prerequisite[0]);
                edges.put(prerequisite[1], set);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<numCourses; i++) {
            if(!inDegree.containsKey(i)) {
                queue.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            res.add(cur);

            if(!edges.containsKey(cur)) {
                continue;
            }

            for(Integer i: edges.get(cur)) {
                inDegree.put(i, inDegree.get(i)-1);
                if(inDegree.get(i)==0) {
                    queue.offer(i);
                }
            }
        }

        if(res.size()<numCourses) {
            return new int[]{};
        }

        int[] result = new int[res.size()];
        for(int i=0; i< res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
