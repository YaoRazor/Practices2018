package advanced.chapterfive;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {

    public boolean isScramble(String s1, String s2) {
        if(s1.length()==0 && s2.length()==0) {
            return true;
        } else if(s1.length()!=s2.length()) {
            return false;
        }

        Map<String, Boolean> map = new HashMap<>();
        Boolean ans =  isScramble(s1, s2, map);
        System.out.println(map.toString());
        return ans;
    }

    private boolean isScramble(String s1, String s2, Map<String, Boolean> map) {
        String key = s1+"#"+s2;
        if(map.containsKey(key)) {
            return map.get(key);
        }

        if(s1.length()==1) {
            if(s1.equals(s2)) {
                map.put(key, true);
            } else {
                map.put(key, false);
            }

            return map.get(key);
        }

        int n = s1.length();

        for(int k=1; k<n; k++) {

            if((isScramble(s1.substring(0,k), s2.substring(0, k), map) && isScramble(s1.substring(k, n), s2.substring(k, n), map)) ||
                    (isScramble(s1.substring(0,k), s2.substring(n-k, n), map) && isScramble(s1.substring(k, n), s2.substring(0, n-k), map))) {
                map.put(key, true);
                return true;
            }
        }

        map.put(key, false);
        return false;
    }
}
