package dp;

// For substring or subsequence problems, dp is a natural solution
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        if(s==null || s.length()==0 || t==null || t.length()==0) {
            return 0;
        }

        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m][n];
        dp[0][0] = s.charAt(0)==t.charAt(0)?1:0;

        for(int i=1; i<m; i++) {
            dp[i][0] = dp[i-1][0] + (s.charAt(i)==t.charAt(0)? 1:0);
            for(int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + (s.charAt(i)==t.charAt(j)? dp[i-1][j-1]:0);
            }
        }

        return dp[m-1][n-1];
    }
}
