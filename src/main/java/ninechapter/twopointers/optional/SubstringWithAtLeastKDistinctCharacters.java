package ninechapter.twopointers.optional;

import java.util.HashMap;
import java.util.Map;

public class SubstringWithAtLeastKDistinctCharacters {

    public long kDistinctCharacters(String s, int k) {
        if(s==null || s.length()==0) {
            return 0l;
        }

        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        long total = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c)+1);
            }

            if(map.size()<k) {
                continue;
            }

            while(map.size()==k) {
                total+=s.length()-i;
                char tmp = s.charAt(j);
                map.put(tmp, map.get(tmp)-1);
                if(map.get(tmp)==0) {
                    map.remove(tmp);
                }
                j++;
            }
        }

        return total;
    }
}
