package ninechapter.dp_topdown;

public class WildCardMatching {

    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        // Init base case
        for(int j=1; j<=n; j++) {

            if(p.charAt(j-1)=='*') {
                dp[0][j] = dp[0][j-1];
            }
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if((s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.')&& dp[i-1][j-1]) {
                    dp[i][j] = true;
                } else if(p.charAt(j-1)=='*') {

                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }

        }


        return dp[m][n];

    }


    public boolean isMatchTopDown(String s, String p) {
        if(s==null || p==null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        boolean[][] visited = new boolean[s.length()+1][p.length()+1];

        return isMatch(s, 0, p, 0, dp, visited);
    }

    private boolean isMatch(String s, int i, String p, int j, boolean[][] dp, boolean[][] visited) {
        if(visited[i][j]) {
            return dp[i][j];
        }
        visited[i][j] = true;

        if(i==s.length()) {
            dp[i][j] = isEmpty(p, j);
            return dp[i][j];
        }

        if(j==p.length()) {
            dp[i][j] = false;
            return false;
        }

        char pCur = p.charAt(j);
        char cCur = s.charAt(i);

        if(pCur=='*') {
            dp[i][j] = isMatch(s, i+1, p, j, dp, visited) ||  isMatch(s, i, p, j+1, dp, visited);
        } else {
            if(isCharMatch(cCur, pCur)) {
                dp[i][j] = isMatch(s, i+1, p, j+1, dp, visited);
            } else {
                dp[i][j] = false;
            }
        }
        return dp[i][j];
    }

    private boolean isEmpty(String p, int j) {
        for(int k=j; k<p.length(); k++) {
            if(p.charAt(k)!='*') {
                return false;
            }
        }
        return true;
    }


    private boolean isCharMatch(char c, char p) {
        return c==p || p=='?';
    }
}
