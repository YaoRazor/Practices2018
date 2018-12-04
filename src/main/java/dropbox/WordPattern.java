package dropbox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {

        if(pattern==null || pattern.length()==0) {
            return false;
        }

        String[] array = str.split("\\s+");

        if(pattern.length()!=array.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(int i=0; i<pattern.length(); i++) {

            char cur = pattern.charAt(i);

            if(!map.containsKey(cur)) {
                if(set.contains(array[i])) {
                    return false;
                }

                map.put(cur, array[i]);
                set.add(array[i]);

            } else {
                if(!array[i].equals(map.get(cur))) {
                    return false;
                }
            }


        }


        return true;

    }
}
