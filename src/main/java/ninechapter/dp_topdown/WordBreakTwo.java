package ninechapter.dp_topdown;

import java.util.List;
import java.util.*;

// 时间复杂度在加了DP之后仍然是指数级，因为在最坏情况，每一个分割都是解，那么总共
// 有2^n个解. https://www.jiuzhang.com/qa/2994/
public class WordBreakTwo {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> tmp = new ArrayList<>();
        tmp.add("");
        map.put(s.length(), tmp);
        int maxLength = getMaxLength(wordDict);

        return dfs(s, 0, set, map, maxLength);
    }

    private List<String> dfs(String s, int start, Set<String> set, Map<Integer, List<String>> map, int maxLength) {
        if(map.containsKey(start)) {
            return map.get(start);
        }

        List<String> ans = new ArrayList<>();

        for(int i=start+1; i<=start+maxLength && i<=s.length(); i++) {
            String cur = s.substring(start, i);
            if(!set.contains(cur)) {
                continue;
            }

            List<String> next = dfs(s, i, set, map, maxLength);
            for(String tmp: next) {
                if(tmp.length()==0) {
                    ans.add(cur);
                } else {
                    ans.add(cur+" "+tmp);
                }
            }
        }

        map.put(start, ans);
        return ans;
    }

    private int getMaxLength(final List<String> wordDict) {
        int ans = 0;
        for(String str: wordDict) {
            ans = Math.max(ans, str.length());
        }
        return ans;
    }
}
