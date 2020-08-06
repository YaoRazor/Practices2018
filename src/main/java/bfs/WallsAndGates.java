package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

// 从多个Gate同时向Room做BFS，而且只有当前点是Room，且距离是Integer.MAX_VALUE的时候才更新值
// 这样确保了每个点最多只被更新了一次，所以Time complexity是O(m*n)
public class WallsAndGates {
    private static int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1, 0}};

    public void wallsAndGates(int[][] rooms) {
        if(rooms==null || rooms.length==0 || rooms[0]==null || rooms[0].length==0) {
            return;
        }

        Queue<Point> queue = new ArrayDeque<>();

        for(int i=0; i<rooms.length; i++) {
            for(int j=0; j<rooms[0].length; j++) {
                if(rooms[i][j]==0) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        int n = rooms.length;
        int m = rooms[0].length;

        while(!queue.isEmpty()) {
            Point cur = queue.poll();

            for(int[] dir: dirs) {
                int x = cur.x+dir[0];
                int y = cur.y+dir[1];
                if(x<0 || x==n || y<0 || y==m || rooms[x][y]!=Integer.MAX_VALUE) {
                    continue;
                }

                rooms[x][y] = rooms[cur.x][cur.y]+1;
                queue.offer(new Point(x, y));
            }
        }
    }

    class Point {
        int x;
        int y;
        Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
