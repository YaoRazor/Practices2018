package ninechapter.dp_topdown;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// TC: 0(N^3) because s.substring() cost also O(n) time
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        // This can speed up the process when s is quite long
        int maxLength = getMaxLength(set);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;

        for(int i=n-1; i>=0; i--) {
            for(int j=i+1; j<=n; j++) {
                if(j-i>maxLength) {
                    break;
                }

                // Put dp[j] before set.contains(s.substring(i, j)
                // can speed up the process
                if(dp[j] && set.contains(s.substring(i, j))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

    private int getMaxLength(Set<String> set) {
        int ans = 0;
        for(String word: set) {
            ans = Math.max(ans, word.length());
        }

        return ans;
    }

}
