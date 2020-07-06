package advanced.chapterseven.optional;

public class BuildPostOffice {

    // O(Math.max(n^2, m^2, n*m))
    public int shortestDistance(int[][] grid) {
        if(grid==null || grid[0].length==0 || grid[0]==null || grid[0].length==0) {
            return -1;
        }

        int n = grid.length;
        int m = grid[0].length;

        int[] rowNum = new int[n];
        int[] colNum = new int[m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==1) {
                    rowNum[i]++;
                    colNum[j]++;
                }
            }
        }

        int[] rowDistance = getDistance(rowNum);
        int[] colDistance = getDistance(colNum);

        int ans = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==0) {
                    ans = Math.min(ans, rowDistance[i]+colDistance[j]);
                }
            }
        }

        return ans;
    }

    private int[] getDistance(int[] array) {
        int n = array.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                ans[i]+= array[j]*Math.abs(j-i);
            }
        }

        return ans;
    }
}
