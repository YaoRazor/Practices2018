package ninechapter.dp_topdown;

import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length()+1];
        int maxLength = getMaxLength(dict);
        return isBreak(s, 0, dict, dp, maxLength);
    }

    private boolean isBreak(String s, int start, Set<String> dict, boolean[] dp, int maxLength) {
        if(start==s.length()) {
            return true;
        }

        if(dp[start]) {
            return true;
        }

        for(int i=start+1; i<=s.length() && i<=start+maxLength; i++) {
            String tmp = s.substring(start, i);
            if(!dict.contains(tmp)) {
                continue;
            }

            if(isBreak(s, i, dict, dp, maxLength)) {
                dp[start] = true;
                return true;
            }
        }
        return false;
    }

    private int getMaxLength(Set<String> dict) {
        int size = 0;

        for(String tmp: dict) {
            size = Math.max(size, tmp.length());
        }

        return size;
    }
}
