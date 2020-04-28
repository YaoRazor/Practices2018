package ninechapter.dp_topdown;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
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

        // The difference between WildCard and RegularExpression is that
        // RegularExpress problem focuses more on next char and combines
        // "a*" as a whole, while WildCard only considers current char, it
        // does not consider the next char.
        if(j+1<p.length() && p.charAt(j+1)=='*') {
            dp[i][j] = isMatch(s, i, p, j+2, dp, visited) ||
                    (isCharMatch(cCur, pCur) && isMatch(s, i+1, p, j, dp, visited));
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
        // There is also a difference here between WildCard and Regular Expression
        for(int k=j; k<p.length(); k+=2) {
            if(k+1==p.length() || p.charAt(k+1)!='*') {
                return false;
            }
        }
        return true;
    }


    private boolean isCharMatch(char c, char p) {
        return c==p || p=='.';
    }
}
