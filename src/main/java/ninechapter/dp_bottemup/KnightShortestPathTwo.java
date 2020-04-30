package ninechapter.dp_bottemup;

import java.util.*;

public class KnightShortestPathTwo {
    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // There is another way of doing this problem
    // that is to use dp. The difference between this
    // one and KnightShortestPaths is that there is no
    // circular dependency in this problem, that is required
    // for this problem to be solvable by dp
    public int shortestPath2(boolean[][] grid) {
        if(grid[0][0]) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0, 0));
        visited[0][0] = true;
        int distance = 0;

        int[][] dirs = {{1, 2}, {-1, 2}, {2, 1}, {-2, 1}};

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i< size; i++) {
                Point cur = queue.poll();

                for(int[] dir: dirs) {
                    int newX = cur.x+dir[0];
                    int newY = cur.y+dir[1];

                    if(newX>=0 && newX<m && newY>=0 && newY<n && !grid[newX][newY]) {
                        if(newX==m-1 && newY==n-1) {
                            return distance+1;
                        }

                        if(!visited[newX][newY]) {
                            queue.offer(new Point(newX, newY));
                            visited[newX][newY] = true;
                        }

                    }
                }
            }

            distance++;
        }

        return -1;
    }
}
