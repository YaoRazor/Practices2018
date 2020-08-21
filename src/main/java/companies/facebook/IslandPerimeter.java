package companies.facebook;

import java.util.ArrayDeque;
import java.util.Queue;

public class IslandPerimeter {

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int islandPerimeter(int[][] grid) {
        int ans = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1) {
                    ans = getPerimeter(grid, i, j);
                    return ans;
                }
            }
        }

        return ans;
    }

    private int getPerimeter(int[][] grid, int i, int j) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<int[]> queue = new ArrayDeque<>();
        int cnt = 0;
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int[] dir: dirs) {
                int x = cur[0]+dir[0];
                int y = cur[1]+dir[1];

                if(x<0 || x==grid.length || y<0 || y==grid[0].length || grid[x][y]==0) {
                    cnt++;
                    continue;
                }

                if(!visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }

        return cnt;
    }

}
