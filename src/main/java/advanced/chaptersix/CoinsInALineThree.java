package advanced.chaptersix;

public class CoinsInALineThree {

    // TC: O(N^2)
    public boolean firstWillWin(int[] values) {
        if(values==null || values.length<2) {
            return true;
        }

        int n = values.length;

        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++) {
            dp[i][i] = values[i];
        }

        for(int len=2; len<=n; len++) {
            for(int i=0; i+len-1<n; i++) {
                int j = i+len-1;
                for(int k=i; k<j; k++) {
                    dp[i][j] = Math.max(values[i]-dp[i+1][j], values[j]-dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1]>=0;
    }
}
