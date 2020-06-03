package ninechapter.bfs.optional;

import java.util.*;


// This problem is not a typical use case of bfs, we need to generalize the
// solution for this kind of problems.
public class TheMazeTwo {

    int[][] dirs = {{1, 0}, {-1, 0}, {0,1},{0,-1}};

    class Position {
        public int x;
        public int y;
        public int cnt;
        public Position(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    private boolean isValid(int[][] maze, int x, int y){
        if(x>=0 && x<maze.length && y>=0 && y<maze[0].length && maze[x][y]==0) {
            return true;
        }

        return false;
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];

        // Need distance of all points on the matrix
        for(int i=0; i<maze.length; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        // No need to use visited matrix, because one point can be visited
        // multiple times
        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(start[0], start[1], 0));

        while(queue.size()>0) {
            Position cur = queue.poll();

            // This is key to reduce queue size, if we find another
            // way to be shorter, then we use another way, otherwise
            // we will skip this path.
            if(cur.cnt>=distance[cur.x][cur.y]) {
                continue;
            }

            distance[cur.x][cur.y] = cur.cnt;

            for(int[] dir: dirs) {
                int x = cur.x;
                int y = cur.y;
                int cnt = cur.cnt;

                while(isValid(maze, x, y)) {
                    x+=dir[0];
                    y+=dir[1];
                    cnt++;
                }

                cnt--;
                x-=dir[0];
                y-=dir[1];
                queue.offer(new Position(x, y, cnt));
            }
        }

        return distance[destination[0]][destination[1]]==Integer.MAX_VALUE? -1: distance[destination[0]][destination[1]];
    }
}
