package ninechapter.bfs;;


import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) {
            return 0;
        }

        int ans = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {

                if(grid[i][j]=='1') {
                    ans++;
                    dfs(grid, i, j);
                }


            }
        }

        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0') {
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

    public int numIslands(boolean[][] grid) {
        if(grid==null || grid.length==0) {
            return 0;
        }

        int cnt = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {

                if(grid[i][j]) {
                    cnt++;
                    bfs(grid, i, j);
                }

            }
        }

        return cnt;
    }

    class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void bfs(boolean[][] grid, int i, int j) {
        int[][] delta = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(i, j));
        grid[i][j] = false;

        while(!queue.isEmpty()) {

            Position cur = queue.poll();

            for(int k=0; k<4; k++) {
                int x = cur.x+delta[k][0];
                int y = cur.y+delta[k][1];

                if(x>=0 && x<grid.length && y>=0 && y<grid[x].length && grid[x][y]) {
                    queue.offer(new Position(x, y));
                    grid[x][y] = false;
                }
            }
        }

    }
}
