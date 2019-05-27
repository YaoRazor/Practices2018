package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseScheduleTwo {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i=0; i<numCourses; i++) {
            indegree.put(i, 0);
            map.put(i, new HashSet<>());
        }

        for(int i=0; i<prerequisites.length; i++) {
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];

            indegree.put(to, indegree.get(to)+1);
            map.get(from).add(to);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> visited = new ArrayList<>();

        for(Integer i: indegree.keySet()) {

            if(indegree.get(i)==0) {
                deque.addLast(i);
            }

        }

        while(!deque.isEmpty()) {

            Integer cur = deque.pollFirst();

            visited.add(cur);

            for(Integer i: map.get(cur)) {

                indegree.put(i, indegree.get(i)-1);

                if(indegree.get(i)==0) {

                    deque.addLast(i);

                }

            }

        }

        if(visited.size()!=numCourses) {
            return new int[]{};
        } else {
            return visited.stream().mapToInt(i->i).toArray();
        }
    }
}
