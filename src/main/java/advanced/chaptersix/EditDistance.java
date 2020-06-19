package advanced.chaptersix;

public class EditDistance {

    // TC: O(n*m)
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // We add one more dimension in each direction for easier problem set-up
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++) {
            dp[i][0] = i;
        }

        for(int j=0; j<=n; j++) {
            dp[0][j] = j;
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)) {
                    // 这里有一个关键点是如果最后一位相等的话dp[i][j] = dp[i-1][j-1], 这个可以通过反证法正面
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // 这里是常规的DP推导
                    dp[i][j] = Math.min(dp[i-1][j-1]+1, Math.min(dp[i-1][j]+1, dp[i][j-1]+1));
                }
            }

        }

        return dp[m][n];
    }
}
