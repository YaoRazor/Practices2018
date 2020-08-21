package ninechapter.dp_topdown;

import java.util.List;
import java.util.*;

public class WordBreakTwo {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        if(s==null || s.length()==0 || wordDict==null || wordDict.size()==0) {
            return ans;
        }

        int n = s.length();
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> tmp = new ArrayList<>();
        tmp.add("");
        map.put(n, tmp);

        return dfs(s, map, 0, new HashSet<>(wordDict), getMaxLength(wordDict));
    }

    private List<String> dfs(String s, Map<Integer, List<String>> map, int start, Set<String> wordDict, int maxLength) {
        if(map.containsKey(start)) {
            return map.get(start);
        }

        List<String> ans = new ArrayList<>();

        for(int i=start+1; i<=s.length(); i++) {
            String curString = s.substring(start, i);
            if(!wordDict.contains(curString)) {
                continue;
            }

            List<String> tmp = dfs(s, map, i, wordDict, maxLength);

            for(String str: tmp) {
                if(str.equals("")) {
                    ans.add(curString);
                } else {
                    ans.add(curString+" "+str);
                }
            }
        }

        map.put(start, ans);
        return ans;
    }

    private int getMaxLength(List<String> set) {
        int ans = 0;
        for(String word: set) {
            ans = Math.max(ans, word.length());
        }

        return ans;
    }
}
