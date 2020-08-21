package ninechapter.dp_topdown;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int maxLength = getMaxLength(set);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;

        for(int i=n-1; i>=0; i--) {
            for(int j=i+1; j<=n; j++) {
                if(j-i>maxLength) {
                    break;
                }

                if(set.contains(s.substring(i, j)) && dp[j]) {
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
