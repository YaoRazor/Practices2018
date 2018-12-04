package bfs;


import java.util.ArrayDeque;
import java.util.Deque;

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



    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslandsBFS(char[][] grid) {

        if(grid==null || grid.length==0 || grid[0].length==0) {
            return 0;
        }


        int n = grid.length;
        int m = grid[0].length;

        // boolean[][] visited = new boolean[n][m];

        int cnt =0;


        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {

                if(grid[i][j]=='1') {
                    cnt++;
                    // 以此点为中心做BFS，这样就可以把该点相邻的点都mark成0，这是BFS在这里的一个特殊用法
                    // 一般BFS都是全图做，在这道题中，我们对于每一个遇到的1做BFS，相当于去重
                    bfs(grid, i, j);

                }
            }

        }

        return cnt;

    }

    class Point{
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }


    private void bfs(char[][] grid, int i, int j) {

        Deque<Point> deque = new ArrayDeque<>();
        grid[i][j] = '0';
        deque.addLast(new Point(i, j));


        while(!deque.isEmpty()) {

            Point cur = deque.pollFirst();

            for(int[] dir: dirs) {

                int dx = cur.i+dir[0];
                int dy = cur.j+dir[1];

                if(dx<0 || dx>=grid.length || dy<0 || dy>=grid[0].length || grid[dx][dy]=='0') {
                    continue;
                }

                deque.addLast(new Point(dx, dy));
                grid[dx][dy] = '0';
                // 因为我们已经修改原图了，所以这里不用Visited点来去重也可以
                // visited[dx][dy] = true;

            }

        }

        return;

    }
}
