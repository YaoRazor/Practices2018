package ninechapter.dp_topdown;

import java.util.*;

public class WordBreakThree {
    public int wordBreak3(String s, Set<String> dict) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        int maxLength = getMaxLength(dict);

        Set<String> newSet = new HashSet<>();
        for(String tmp: dict) {
            newSet.add(tmp.toLowerCase());
        }

        return numberOfBreak(s, 0, newSet, dp, maxLength);
    }

    private int numberOfBreak(String s, int start, Set<String> dict, int[] dp, int maxLength) {
        if(dp[start]>=0) {
            return dp[start];
        }

        if(start==s.length()) {
            dp[start] = 1;
            return 1;
        }

        dp[start] = 0;

        for(int i=start+1; i<=s.length() && i<=start+maxLength; i++) {
            String tmp = s.substring(start, i).toLowerCase();
            if(!dict.contains(tmp)) {
                continue;
            }

            int cnt = numberOfBreak(s, i, dict, dp, maxLength);
            dp[start] +=cnt;
        }
        return dp[start];
    }

    private int getMaxLength(Set<String> dict) {
        int size = 0;

        for(String tmp: dict) {
            size = Math.max(size, tmp.length());
        }

        return size;
    }
}
