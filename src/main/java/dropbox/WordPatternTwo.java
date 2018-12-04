package dropbox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternTwo {
    public boolean wordPatternMatch(String pattern, String str) {

        Map<Character, String> map = new HashMap<>();
        //只要有一个set就可以了
        Set<String> set = new HashSet<>();

        return dfs(pattern, str, 0, map, set);
    }


    private boolean dfs(String pattern, String str, int start, Map<Character, String> map, Set<String> set) {

        if(start==pattern.length()) {

            if(str.equals("")) {
                return true;
            } else {
                return false;
            }

        }

        char cur = pattern.charAt(start);

        if(map.containsKey(cur)) {

            String match = map.get(cur);
            if(!str.startsWith(match)) {
                return false;
            } else {
                return dfs(pattern, str.substring(match.length()), start+1, map, set);
            }

        }

        for(int i=1; i<=str.length(); i++) {
            String subString = str.substring(0, i);

            if(set.contains(subString)) {
                continue;
            }

            map.put(cur, subString);
            set.add(subString);

            if(dfs(pattern, str.substring(i), start+1, map, set)) {
                return true;
            } else {
                //注意这里有一个backtracking
                map.remove(cur);
                set.remove(subString);
            }
        }

        return false;

    }
}
