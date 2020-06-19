package advanced.chaptersix;

public class BackPackTwo {

    // TC: O(n*m), using rolling array, we can optimize
    // the SC to O(2*m)-> O(m)
    public int backPackII(int m, int[] A, int[] V) {
        if(m==0 || A==null || A.length==0) {
            return 0;
        }

        int n = A.length;

        // dp[i][j] denotes the maximum value we can pack
        // with the first i items(not necessarily includes every item) and j size
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 0;
        for(int i=1; i<=m; i++) {
            dp[0][i] = -1;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                dp[i][j] = dp[i-1][j];

                if(j>=A[i-1] && dp[i-1][j-A[i-1]]!=-1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-A[i-1]]+V[i-1]);
                }
            }
        }

        int ans = 0;
        for(int i=m; i>=0; i--) {
            if(dp[n][i]!=-1) {
                ans = Math.max(ans, dp[n][i]);
            }
        }

        return ans;
    }
}
