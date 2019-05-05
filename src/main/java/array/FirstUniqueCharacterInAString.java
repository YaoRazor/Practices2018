package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yawang on 4/29/18.
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {

        if(s==null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {

            Character cur = s.charAt(i);

            if(map.containsKey(cur)) {
                map.put(cur, map.get(cur)+1);
            } else {
                map.put(cur, 1);
            }
        }

        for(int i=0; i<s.length(); i++) {

            if(map.get(s.charAt(i))==1) {
                return i;
            }
        }

        return -1;

    }
}
