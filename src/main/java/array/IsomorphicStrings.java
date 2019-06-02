package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s==null || t==null || s.length()!=t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            char curT = t.charAt(i);
            if(!map.containsKey(cur)) {
                if(set.contains(curT)) {
                    return false;
                }
                map.put(cur, t.charAt(i));
                set.add(curT);
            } else {
                char mapping = map.get(cur);
                if(mapping!=curT) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isIsomorphicOptimal(String s, String t) {
        if(s==null || t==null || s.length()!=t.length()) {
            return false;
        }
        int[] sMap = new int[256];
        int[] tMap = new int[256];

        for(int i=0; i<s.length(); i++) {

            if(sMap[s.charAt(i)]!=tMap[t.charAt(i)]) {
                return false;
            }

            sMap[s.charAt(i)] = tMap[t.charAt(i)] = i+1;
        }

        return true;
    }
}
