package advanced.chapterfive;


/*
  This problem is solved by dynamically programming using memorization
 */
public class LongestContinuousIncreasingSubsequenceTwo {

    private static int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1, 0}};

    public int longestContinuousIncreasingSubsequence2(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        // dp[i][j] represents the len increaseing subsequence ending at i,j
        int[][] dp = new int[n][m];
        int ans = 1;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                ans = Math.max(ans, search(matrix, dp, i, j));
            }
        }

        return ans;
    }

    private int search(int[][] matrix, int[][] dp, int i, int j) {
        if(dp[i][j]!=0) {
            return dp[i][j];
        }

        dp[i][j] = 1;

        for(int[] dir: dirs) {
            int nx = i+dir[0];
            int ny = j+dir[1];

            // Usually for a search in the matrix, we will need to use a set to prevent revisiting
            // the previous position, however, because we are looking for postitions with increasing
            // value, there will not be possibility of revisiting previous postion, but there are
            // still duplicated sub-problems, that is why we are use memorization here.
            if(nx<0 || nx>=matrix.length || ny<0 || ny>=matrix[0].length || matrix[i][j]<=matrix[nx][ny]) {
                continue;
            }

            dp[i][j] = Math.max(search(matrix, dp, nx, ny)+1, dp[i][j]);
        }

        return dp[i][j];
    }
}
