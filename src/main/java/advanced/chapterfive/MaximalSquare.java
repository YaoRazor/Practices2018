package advanced.chapterfive;

public class MaximalSquare {
    // dp[i][j]代表右下角为[i][j]的正方形的边长
    // 推导公式是dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
    // base case是第一行和第一列如果是1，那么初始值是1，如果是0，那么初始值是0
    // TC: O(nm), SC: O(nm)
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans = 0;

        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][0]=='1') {
                dp[i][0] = 1;
                ans = 1;
            }
        }

        for(int i=0; i<matrix[0].length; i++) {
            if(matrix[0][i]=='1') {
                dp[0][i] = 1;
                ans = 1;
            }
        }

        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][j]=='1') {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    ans = Math.max(dp[i][j], ans);

                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans*ans;
    }
}
