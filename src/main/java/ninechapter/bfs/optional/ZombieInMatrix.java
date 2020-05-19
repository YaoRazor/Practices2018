package ninechapter.bfs.optional;

import java.util.ArrayDeque;
import java.util.Queue;

public class ZombieInMatrix {
    class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int zombie(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0]==null || grid[0].length==0) {
            return 0;
        }

        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        Queue<Position> queue = new ArrayDeque<>();

        // There is a slight difference between this problem and normal bfs problem
        // That is we need an extra total number to know that all people have been killed,
        // otherwise, we might undergo an extra step in bfs
        int total = 0;
        int m = grid.length;
        int n= grid[0].length;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1) {
                    queue.offer(new Position(i, j));
                }

                if(grid[i][j]==0) {
                    total++;
                }
            }
        }

        int ans = 0;

        while(total>0 && !queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                Position cur = queue.poll();

                for(int[] dir: dirs) {
                    int x = dir[0] + cur.x;
                    int y = dir[1] + cur.y;

                    if(isValid(grid, x, y) && grid[x][y]==0) {
                        grid[x][y] = 1;
                        total--;
                        queue.offer(new Position(x, y));
                    }
                }

            }

            ans++;
        }

        if(total>0) {
            return -1;
        } else {
            return ans;
        }
    }

    private boolean isValid(int[][] grid, int x, int y) {
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length) {
            return false;
        }
        return true;
    }
}
