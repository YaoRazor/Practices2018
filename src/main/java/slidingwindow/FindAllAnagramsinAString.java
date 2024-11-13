package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// sliding window. TC: O(N)
public class FindAllAnagramsinAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;

        for(char c: p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        // This is one of the keys, not counting total characters
        // but only counting total distinct characters
        int cnt = map.size();

        // Another key is to keep the window as the length of p
        for(; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if(map.get(c)==0) {
                    cnt--;
                    if(cnt ==0) {
                        ans.add(j);
                    }
                }
            }

            if(i>=p.length()-1) {
                char toRemove = s.charAt(i-p.length()+1);
                if(map.containsKey(toRemove)) {
                    map.put(toRemove, map.get(toRemove)+1);
                    // only track from 0 to 1 to increase cnt
                    if(map.get(toRemove)==1) {
                        cnt++;
                    }
                }
                j++;
            }

        }

        return ans;
    }
}
