package dp;


public class UniquePathTwo {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid==null || obstacleGrid.length==0) {
            return 0;
        }

        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;


        int[] dp = new int[m];

        dp[0] = obstacleGrid[0][0] == 0? 1:0;

        for(int i=1; i<m; i++) {
            dp[i] = obstacleGrid[0][i]==0? dp[i-1]:0;
        }

        for(int i=1; i<n; i++) {

            if(obstacleGrid[i][0]==1) {
                dp[0] = 0;
            }

            for(int j=1; j<m; j++) {
                if(obstacleGrid[i][j]==1) {
                    dp[j] = 0;
                } else {
                    dp[j]+=dp[j-1];
                }
            }
        }

        return dp[m-1];

    }
}
