package companies.facebook;

import java.util.ArrayDeque;
import java.util.Queue;

public class BattleshipsInABoard {

    public int countBattleships(char[][] grid) {
        int ans = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int cnt = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='X' && !isVisited[i][j]) {
                    cnt++;
                    bfs(grid, i, j, isVisited);
                }
            }
        }

        return cnt;
    }

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int[] dir: dirs) {
                int x = cur[0]+dir[0];
                int y = cur[1]+dir[1];

                if(x<0 || x==grid.length || y<0 || y==grid[0].length || grid[x][y]=='.' || visited[x][y]) {
                    continue;
                }

                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
}
