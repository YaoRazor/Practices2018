package advanced.chaptersix.optional;

public class InterleavingString {

    // TC: O(n*m), SC: O(n*m)
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null || s2==null || s3==null) {
            return false;
        }

        if(s1.length()+s2.length()!=s3.length()) {
            return false;
        }

        int n = s1.length();
        int m = s2.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i=1; i<=m; i++) {
            if(dp[0][i-1] && s2.charAt(i-1)==s3.charAt(i-1)) {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for(int i=1; i<=n; i++) {
            if(dp[i-1][0] && s1.charAt(i-1)==s3.charAt(i-1)) {
                dp[i][0] = true;
            } else {
                break;
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                char c = s3.charAt(i+j-1);
                if((s1.charAt(i-1)==c && dp[i-1][j]) || (s2.charAt(j-1)==c && dp[i][j-1])) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][m];
    }
}
