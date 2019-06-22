package unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsTwo {
    int sum = 0;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        int[] grid = new int[m*n];
        Arrays.fill(grid, 0);
        int[] parent = new int[m*n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                parent[i*n+j] = i*n+j;
            }
        }

        for(int[] position: positions) {
            int index = position[0]*n +position[1];

            if(grid[index]==1) {
                ans.add(sum);
                continue;
            }

            sum++;
            grid[index] = 1;
            search(grid, parent, position[0], position[1], m, n);
            ans.add(sum);
        }

        return ans;
    }

    private void search(int[] grid, int[] parent, int row, int col, int m, int n) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int[] dir: dirs) {
            int newRow = row+dir[0];
            int newCol = col+dir[1];
            int index = newRow*n+newCol;

            if(isValid(newRow, newCol, m, n) && grid[index]==1) {
                union(row*n+col, index, parent);
            }
        }
    }

    private boolean isValid(int row, int col, int m, int n) {
        if(row<0 || row>=m || col<0 || col>=n) {
            return false;
        }
        return true;
    }

    private int find(int value, int[] parent) {
        int root = value;

        while(parent[root]!=root) {
            root = parent[root];
        }

        while(parent[value]!=root) {
            int tmp = parent[value];
            parent[value] = root;
            value = tmp;
        }

        return root;
    }

    private void union(int x, int y, int[] parent) {
        int fx = find(x, parent);
        int fy = find(y, parent);

        if(fx!=fy) {
            sum--;
            parent[fx] = fy;
        }

        return;
    }
}
