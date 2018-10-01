package array;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {

        int n = s.length();
        Map<Character, Character> map = new HashMap<>();


        for(int i=0; i<n; i++) {

            Character a = s.charAt(i);
            Character b = t.charAt(i);

            if(map.containsKey(a)) {

                if(!b.equals(map.get(a))) {
                    return false;
                }
            } else if (map.values().contains(b)) {
                return false;
            } else {
                map.put(a, b);
            }

        }

        return true;

    }
}
