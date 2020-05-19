package ninechapter.bfs.optional;

import datastructures.UndirectedGraphNode;
import java.util.*;

public class SixDegree {

    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(s);

        int cnt = 0;

        while(queue.size()>0) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                UndirectedGraphNode cur = queue.poll();
                if(cur==t) {
                    return cnt;
                }

                for(UndirectedGraphNode neighbor: cur.neighbors) {
                    if(!set.contains(neighbor)) {
                        queue.offer(neighbor);
                        set.add(neighbor);
                    }
                }
            }

            cnt++;
        }

        return -1;
    }
}
