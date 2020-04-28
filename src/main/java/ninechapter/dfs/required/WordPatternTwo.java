package ninechapter.dfs.required;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternTwo {

    Map<Character, String> map = new HashMap<>();
    Set<String> set = new HashSet<>();

    public boolean wordPatternMatch(String pattern, String str) {
        return dfs(pattern, 0, str, 0);
    }

    private boolean dfs(String pattern, int index, String str, int start) {
        if(index==pattern.length()) {
            // Pay attention to this base case, index==pattern.length() is not sufficient
            // we also need start == str.length()
            if(start==str.length()) {
                return true;
            } else {
                return false;
            }
        }

        char cur = pattern.charAt(index);
        if(map.containsKey(cur)) {
            String mapping = map.get(cur);
            int size = mapping.length();
            // int leftSize = str.length()-start;
            if(str.length()-start<size || !str.substring(start, start+size).equals(mapping)) {
                return false;
            }

            return dfs(pattern, index+1, str, start+size);

        } else {
            for(int j=start+1; j<=str.length(); j++) {

                String tmp = str.substring(start, j);
                if(set.contains(tmp)) {
                    continue;
                }
                map.put(cur, tmp);
                set.add(tmp);
                if(dfs(pattern, index+1, str, j)) {
                    return true;
                }
                map.remove(cur);
                set.remove(tmp);
            }
            return false;
        }
    }
}
