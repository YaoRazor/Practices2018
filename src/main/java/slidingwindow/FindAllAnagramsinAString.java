package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinAString {

    // 本题的解法是Sliding window
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s==null || s.length()<p.length()) {
            return ans;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(char c: p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int count = 0;

        // keep the window as length of p
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if(map.get(c)==0) {
                    count++;
                    if(count==map.size()) {
                        ans.add(i-p.length()+1);
                    }
                }
            }

            if(i>=(p.length()-1)) {
                char toRemove = s.charAt(i-p.length()+1);
                if(map.containsKey(toRemove)) {
                    map.put(toRemove, map.get(toRemove)+1);
                    if(map.get(toRemove)==1) {
                        count--;
                    }
                }
            }
        }

        return ans;
    }
}
