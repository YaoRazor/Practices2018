package ninechapter.bfs.optional;

import java.util.*;


public class RemoveSubstrings {

    // Although it is under BFS directory, we are using dfs with memorization
    // to solve this problem. For complex problems, always thinking about dfs
    // recursion to divide the problems into solvable sub problems
    public int minLength(String s, Set<String> dict) {
        Map<String, Integer> map = new HashMap<>();
        return minLength(s, dict, map);
    }

    private int minLength(String s, Set<String> dict, Map<String, Integer> map) {
        if(s==null || s.length()==0 || dict.contains(s)) {
            return 0;
        }

        if(map.containsKey(s)) {
            return map.get(s);
        }

        int ans = s.length();

        for(int i=0; i<s.length(); i++) {
            for(String tmp: dict) {
                if(s.startsWith(tmp, i)) {
                    String newString = s.substring(0, i) + s.substring(i+tmp.length());
                    ans = Math.min(minLength(newString, dict, map), ans);
                }
            }
        }

        map.put(s, ans);
        return ans;
    }
}
