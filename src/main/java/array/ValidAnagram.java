package array;

import java.util.HashMap;
import java.util.Map;

// Alternative is to use sorting with higher time complexity but
// lower space complexity
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // Problem description restricts that string can not be null
        // therefore, we are not checking null string here
        if(s.length()!=t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c: t.toCharArray()) {
            if(!map.containsKey(c)) {
                return false;
            }

            if(map.get(c)==0) {
                return false;
            }

            map.put(c, map.get(c)-1);
        }

        return true;
    }
}
