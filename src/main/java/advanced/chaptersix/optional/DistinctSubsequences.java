package advanced.chaptersix.optional;

public class DistinctSubsequences {

    public int numDistinct(String S, String T) {
        if(S==null || T==null || S.length()<T.length()) {
            return 0;
        }

        int n = S.length();
        int m = T.length();

        int[][] dp = new int[2][m+1];

        dp[0][0] = 1;

        for(int i=1; i<m; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++) {
            dp[i%2][0] = 1;
            for(int j=1; j<=m; j++) {
                if(S.charAt(i-1)==T.charAt(j-1)) {
                    dp[i%2][j] = dp[(i-1)%2][j-1]+dp[(i-1)%2][j];
                } else {
                    dp[i%2][j] = dp[(i-1)%2][j];
                }
            }
        }

        return dp[n%2][m];
    }
}
