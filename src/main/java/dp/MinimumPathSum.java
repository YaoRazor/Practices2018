package dp;


public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) {
            return 0;
        }

        int m = grid[0].length;

        int[] dp = new int[m];
        dp[0] = grid[0][0];

        for(int i=1; i<m; i++) {
            dp[i] = grid[0][i]+dp[i-1];
        }

        for(int i= 1; i<grid.length; i++) {
            dp[0]+=grid[i][0];
            for(int j=1; j<m; j++) {

                dp[j] = Math.min(dp[j], dp[j-1])+grid[i][j];
            }
        }

        return dp[m-1];

    }
}
