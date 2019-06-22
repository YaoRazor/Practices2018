package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


// DFS can be used to solve this problem,
// a better approach would be using DP, which will be n^2
public class WorldBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || s.length()==0) {
            return true;
        }

        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n+1];
        dp[n] = true;

        for(int i=n-1; i>=0; i--) {
            for(int j=i+1; j<=n; j++) {
                if(set.contains(s.substring(i, j)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

}
