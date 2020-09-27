package bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

// 从多个Gate同时向Room做BFS，而且只有当前点是Room，且距离是Integer.MAX_VALUE的时候才更新值
// 这样确保了每个点最多只被更新了一次，所以Time complexity是O(m*n)
public class WallsAndGates {
    private static int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1, 0}};

    public void wallsAndGates(int[][] rooms) {
        Deque<Integer> queue = new ArrayDeque<>();
        int n = rooms.length;
        if(rooms.length==0) {
            return;
        }
        int m = rooms[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(rooms[i][j]==0) {
                    queue.offer(i*m+j);
                }
            }
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur/m;
            int y = cur%m;

            for(int[] dir: dirs) {
                int newX = x+dir[0];
                int newY = y+dir[1];

                if(newX<0 || newX==n || newY<0 || newY==m || rooms[newX][newY]!=Integer.MAX_VALUE) {
                    continue;
                }

                queue.offer(newX*m+newY);
                rooms[newX][newY] = 1+ rooms[x][y];
            }
        }
    }
}
