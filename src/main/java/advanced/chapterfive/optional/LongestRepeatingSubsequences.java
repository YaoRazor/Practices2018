package advanced.chapterfive.optional;

public class LongestRepeatingSubsequences {

    // O(n^2), space can be optimized by rolling array
    public int longestRepeatingSubsequence(String str) {
        if(str==null || str.length()==0) {
            return 0;
        }

        int n = str.length();

        int[][] dp = new int[n+1][n+1];

        for(int i=0; i<=n; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++) {
            dp[i][0] = 0;
            for(int j=1; j<=n; j++) {
                if(str.charAt(i-1)==str.charAt(j-1) && i!=j) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][n];
    }
}
