package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j]==2) {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int ans = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int[] cur = queue.poll();

                for(int[] dir: dirs) {
                    int r = cur[0]+dir[0];
                    int c = cur[1]+dir[1];

                    if(r>=0 && r<m && c>=0 && c<n && mat[r][c]==1 && !visited[r][c]){
                        visited[r][c] = true;
                        mat[r][c] = 2;
                        queue.offer(new int[]{r, c});
                    }
                }
            }
            if(!queue.isEmpty()) {
                ans++;
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j]==1) {
                    return -1;
                }
            }
        }

        return ans;
    }
}
