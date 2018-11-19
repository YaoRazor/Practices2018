package dp;


/*
  This problem is solved by dynamically programming using memorization
 */
public class LongestIncreasingPathInAMatrix {

    int[][] dirs = new int[][]{{0,1}, {0, -1}, {1,0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {

        if(matrix==null || matrix.length==0 ) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];

        int ans = 1;

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++)  {

                ans = Math.max(ans, getMaxLongestIncreasingPath(matrix, dp, i, j));

            }

        }

        return ans;
    }


    private int getMaxLongestIncreasingPath(int[][] matrix, int[][] dp, int i, int j) {

        if(dp[i][j]>0) {
            return dp[i][j];
        }

        int longestPath = 1;

        for(int[] dir: dirs) {

            int tx = i+dir[0];
            int ty = j+dir[1];

            // Usually for a search in the matrix, we will need to use a set to prevent revisiting
            // the previous position, however, because we are looking for postitions with increasing
            // value, there will not be possibility of revisiting previous postion, but there are
            // still duplicated sub-problems, that is why we are use memorization here.
            if(tx<0 || ty<0 || tx>=matrix.length || ty>=matrix[0].length || matrix[tx][ty]<=matrix[i][j]) {
                continue;
            }

            longestPath = Math.max(longestPath, 1 + getMaxLongestIncreasingPath(matrix, dp, tx, ty));

        }

        dp[i][j] = longestPath;
        return longestPath;

    }
}
