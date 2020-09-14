package companies.facebook;

import java.util.ArrayDeque;
import java.util.Queue;

public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];

        // 这一题的问题是图有可能不是全联通的
        // 这其实另一种形式的BFS，对于非全联通图的BFS
        // 以前我们的BFS，都是连通图
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
