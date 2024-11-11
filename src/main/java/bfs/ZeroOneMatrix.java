package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j]==0) {
                    queue.offer(new int[]{i,j});
                } else {
                    mat[i][j] = m*n;
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int[] dir: dirs) {
                int r = cur[0]+dir[0];
                int c = cur[1]+dir[1];

                // Basically m*n indicates whether the node was
                // visited or not. Each node in the matrix will
                // only be visited once in the BFS algorithm, so
                // time complexity is O(m*n)
                if(r>=0 && r<m && c>=0 && c<n && mat[r][c]==m*n){
                    mat[r][c] = mat[cur[0]][cur[1]]+1;
                    queue.offer(new int[]{r, c});
                }
            }

        }

        return mat;
    }
}
