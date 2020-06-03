package ninechapter.bfs.optional;

import java.util.*;

public class TheMaze {

    int[][] dirs = {{1, 0}, {-1, 0}, {0,1},{0,-1}};

    class Position {
        public int x;
        public int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean isValid(int[][] maze, int x, int y){
        if(x>=0 && x<maze.length && y>=0 && y<maze[0].length && maze[x][y]==0) {
            return true;
        }

        return false;
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        Queue<Position> queue = new ArrayDeque<>();

        queue.offer(new Position(start[0], start[1]));
        visited[start[0]][start[1]] = true;

        while(queue.size()>0) {
            Position cur = queue.poll();

            if(cur.x==destination[0] && cur.y==destination[1]) {
                return true;
            }

            for(int[] dir: dirs) {
                int x = cur.x;
                int y = cur.y;

                // Rolling all the way for one direction
                while(isValid(maze, x, y)) {
                    x+=dir[0];
                    y+=dir[1];
                }

                x-=dir[0];
                y-=dir[1];

                if(!visited[x][y]) {
                    // The key is only adding changing point
                    queue.offer(new Position(x, y));
                    visited[x][y] = true;
                }
            }
        }

        return false;
    }
}
