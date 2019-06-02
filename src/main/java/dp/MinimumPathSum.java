package dp;


public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0]==null || grid[0].length==0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];
        dp[0] = grid[0][0];

        for(int i=1; i<n; i++) {
            dp[i] = dp[i-1]+grid[0][i];
        }

        for(int j=1; j<m; j++) {
            dp[0] = dp[0]+grid[j][0];
            for(int i=1; i<n; i++) {
                dp[i] = Math.min(dp[i], dp[i-1]) + grid[j][i];
            }
        }

        return dp[n-1];
    }
}
