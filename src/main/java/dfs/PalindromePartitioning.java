package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// DFS+DP
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(s.charAt(i)==s.charAt(j) && (j-i<2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        LinkedList<String> tmp = new LinkedList<>();

        dfs(ans, tmp, 0, dp, s);
        return ans;
    }

    private void dfs( List<List<String>> ans, LinkedList<String> tmp, int start, boolean[][] dp, String s) {
        if(start==dp.length) {
            ans.add(new LinkedList<>(tmp));
            return;
        }

        for(int i=start; i<dp.length; i++) {
            if(dp[start][i]) {
                tmp.add(s.substring(start, i+1));
                dfs(ans, tmp, i+1, dp, s);
                tmp.removeLast();
            }
        }
    }

}
