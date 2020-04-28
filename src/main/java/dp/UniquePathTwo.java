package dp;


public class UniquePathTwo {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0]==null || obstacleGrid[0].length==0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];

        for(int i=0; i<n; i++) {
            if(obstacleGrid[0][i]==1) {
                dp[i] = 0;
                break;
            } else {
                dp[i] = 1;
            }
        }

        for(int i=1; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(obstacleGrid[i][j]==1) {
                    dp[j] = 0;
                    continue;
                }

                if(j!=0) {
                    dp[j] +=dp[j-1];
                }

            }
        }

        return dp[n-1];
    }
}
