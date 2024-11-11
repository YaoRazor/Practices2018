package advanced.chapterone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// prefer to optimal solution for this problem
public class LongestSubstringWithoutRepeatingCharacters {

    // Normal sliding window
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        boolean isNoRepeating = true;;
        int i = 0;
        int j = 0;

        int ans = 0;

        Set<Character> set = new HashSet<>();

        while(j<s.length()) {
            char c = s.charAt(j);
            if(!set.contains(c)) {
                ans = Math.max(ans, j-i+1);

            } else {
                while(i<j && set.contains(c)) {
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            set.add(c);
            j++;
        }

        return ans;
    }

    // Optimal sliding window
    public int lengthOfLongestSubstringTwo(String s) {
            if(s==null || s.isEmpty()) {
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
