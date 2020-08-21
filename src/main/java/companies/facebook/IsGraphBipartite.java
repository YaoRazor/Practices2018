package companies.facebook;

import java.util.ArrayDeque;
import java.util.Queue;

public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(colors[i]!=0) {
                continue;
            }

            colors[i] = 1;

            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);

            // 每次BFS把这个点相关的所有点都BFS一遍
            while(!queue.isEmpty()) {
                int cur = queue.poll();

                for(int next: graph[cur]) {
                    if(colors[next]==0) {
                        colors[next] = -colors[cur];
                        queue.offer(next);
                    } else if(colors[next]!=-colors[cur]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
