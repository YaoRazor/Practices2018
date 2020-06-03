package advanced.chapterone;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    // Normal sliding window
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        boolean isNoRepeating = true;;
        int j = -1;
        int ans = 0;

        for(int i=0; i<s.length(); i++) {

            while(isNoRepeating && j+1<s.length()) {
                j++;
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0)+1);
                if(map.get(c)==2) {
                    isNoRepeating = false;
                    break;
                }
                ans = Math.max(ans, j-i+1);
            }

            char c = s.charAt(i);

            map.put(c, map.get(c)-1);
            if(map.get(c)==1) {
                isNoRepeating = true;
            }
        }

        return ans;
    }

    // Optimal sliding window
    public int lengthOfLongestSubstringTwo(String s) {
            if(s==null || s.length()==0) {
                return 0;
            }

            // j is an invariant which is used to track the nearest duplicate character's index in the current sliding window
            int j = -1;
            Map<Character, Integer> map = new HashMap<>();
            int ans = 1;

            for(int i=0; i<s.length(); i++) {
                char cur = s.charAt(i);
                if(map.containsKey(cur)) {
                    j = Math.max(j, map.get(cur));
                }

                ans = Math.max(ans, i-j);
                map.put(cur, i); // Need to update each character's most updated index
            }

            return ans;
        }
}
