package array;

import java.util.HashMap;
import java.util.Map;

// 还可以使用sorting的方法，时间复杂度高一些，空间复杂度低一些
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null || s.length()!=t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }

        for(int i=0; i<t.length(); i++) {
            char cur = t.charAt(i);
            if(!map.containsKey(cur) || map.get(cur)==0) {
                return false;
            }
            map.put(cur, map.get(cur)-1);
        }

        return true;
    }
}
