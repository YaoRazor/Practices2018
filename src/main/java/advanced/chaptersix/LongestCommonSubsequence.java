package advanced.chaptersix;

public class LongestCommonSubsequence {

    // TC: O(n*m)
    public int longestCommonSubsequence(String A, String B) {
        if(A==null || B==null || A.length()==0 || B.length()==0) {
            return 0;
        }

        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            dp[i][0] = 0;
        }

        for(int i=0; i<=m; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(A.charAt(i-1)==B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] +1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}
