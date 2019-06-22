package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakTwo {

    // For this problem, memorization is easier, we can also use bottom-up to solve this
    // problem
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String>[] dp = new ArrayList[s.length()+1];
        Set<String> set = new HashSet<>(wordDict);
        List<String> intial = new ArrayList<>();
        intial.add("");
        dp[0] = intial;

        for(int i=1; i<=s.length(); i++) {
            List<String> cur = new ArrayList<>();
            for(int j=0; j<i; j++) {
                if(dp[j].size()>0 && set.contains(s.substring(j,i))) {

                    for(String tmp: dp[j]) {
                        cur.add((tmp.equals("")? tmp: tmp+" ")+ s.substring(j, i));
                    }
                }
            }

            dp[i] = cur;
        }

        return dp[s.length()];
    }


    public List<String> wordBreakUsingMemorization(String s, List<String> wordDict) {
        if(s==null || s.length()==0) {
            return new ArrayList<>();
        }

        Map<Integer, List<String>> map = new HashMap<>();

        List<String> tmp = new ArrayList<>();
        tmp.add("");
        map.put(s.length(), tmp);

        Set<String> set = new HashSet<>(wordDict);
        return dfs(s, 0, set, map);
    }

    private List<String> dfs(String s, int start, Set<String> set, Map<Integer, List<String>> map) {
        if(map.containsKey(start)) {
            return map.get(start);
        }

        List<String> ret = new ArrayList<>();

        for(int i=start+1; i<=s.length(); i++) {
            String cur = s.substring(start, i);

            if(set.contains(cur)) {
                List<String> subList = dfs(s, i, set, map);

                for(String str: subList) {
                    if(str.equals("")) {
                        ret.add(cur);
                    } else {
                        ret.add(cur+" "+str);
                    }
                }
            }
        }

        map.put(start, ret);
        return ret;
    }
}
