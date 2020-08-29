package array;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    // The key point is to loop through magazine first
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote==null || magazine==null || ransomNote.length()>magazine.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(char c: magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c: ransomNote.toCharArray()) {
            if(!map.containsKey(c) || map.get(c)==0) {
                return false;
            }

            map.put(c, map.get(c)-1);
        }

        return true;
    }
}
