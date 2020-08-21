package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if(s1==null || s2==null) {
            return false;
        } else if(s2.length()<s1.length()) {

        }

        Map<Character, Integer> map = new HashMap<>();
        for(char c: s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int k = s1.length();
        int cnt = 0;

        for(int i=0; i<s2.length(); i++) {
            char c = s2.charAt(i);
            if(map.containsKey(c))  {
                map.put(c, map.get(c)-1);
                if(map.get(c)==0) {
                    cnt++;
                    if(cnt==map.size()) {
                        return true;
                    }
                }
            }

            if(i>=k-1) {
                int left = i-k+1;
                char tmp = s2.charAt(left);
                if(map.containsKey(tmp)) {
                    map.put(tmp, map.get(tmp)+1);
                    if(map.get(tmp)==1) {
                        cnt--;
                    }
                }
            }
        }

        return false;
    }
}
