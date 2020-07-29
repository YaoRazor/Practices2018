package ninechapter.bfs;;


import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

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

    public int numIslandsUsingBFS(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0]==null || grid[0].length==0) {
            return 0;
        }

        Set<Integer> visited = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='1' && !visited.contains(i*m+j)) {
                    bfs(grid, i, j, visited);
                    ans++;
                }
            }
        }

        return ans;
    }

    private static final int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

    private void bfs(char[][] grid, int i, int j, Set<Integer> visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;

        queue.offer(i*m+j);
        visited.add(i*m+j);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur/m;
            int y = cur%m;

            for(int[] dir: dirs) {
                int newX = x+dir[0];
                int newY = y+dir[1];
                if(newX<0 || newX==n || newY<0 || newY==m || grid[newX][newY]=='0' || visited.contains(newX*m+newY)) {
                    continue;
                }

                queue.offer(newX*m+newY);
                visited.add(newX*m+newY);
            }
        }
    }
}
