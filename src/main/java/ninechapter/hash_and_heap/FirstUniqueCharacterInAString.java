package ninechapter.hash_and_heap;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public char firstUniqChar(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }


        char result='a';

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(map.get(c)==1) {
                result = c;
                break;
            }
        }

        return result;
    }
}
