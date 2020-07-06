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
        if(numCourses==0) {
            return new int[]{};
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for(int i=0; i<numCourses; i++) {
            indegree.put(i, 0);
            graph.put(i, new HashSet<>());
        }

        for(int[] prerequisite: prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];

            indegree.put(to, indegree.get(to)+1);
            graph.get(from).add(to);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<numCourses; i++) {
            if(indegree.get(i)==0) {
                queue.offer(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(queue.size()>0) {
            int cur = queue.poll();
            ans.add(cur);

            for(int neighbor: graph.get(cur)) {
                indegree.put(neighbor, indegree.get(neighbor)-1);
                if(indegree.get(neighbor)==0) {
                    queue.offer(neighbor);
                }
            }
        }

        if(ans.size()<numCourses) {
            return new int[]{};
        } else {
            int[] result = new int[numCourses];
            for(int i=0; i<numCourses; i++) {
                result[i] = ans.get(i);
            }

            return result;
        }
    }
}
