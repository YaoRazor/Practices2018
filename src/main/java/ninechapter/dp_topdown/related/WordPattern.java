package ninechapter.dp_topdown.related;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if(pattern==null || str==null) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        String[] tmp = str.split("\\s+");

        if(tmp.length!=pattern.length()) {
            return false;
        }

        Set<String> set = new HashSet<>();

        for(int i=0; i<tmp.length; i++) {
            char c = pattern.charAt(i);
            if(!map.containsKey(c)) {
                if(set.contains(tmp[i])) {
                    return false;
                }
                map.put(c, tmp[i]);
                set.add(tmp[i]);
            } else {
                if(!map.get(c).equals(tmp[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}
