package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    // Sliding Window
    public int lengthOfLongestSubstring(String s) {

        if(s==null || s.length()==0) {
            return 0;
        }

        int end = 0;
        int start = 0;

        int ans = 0;

        Map<Character, Integer> map = new HashMap<>();

        while(end<s.length()) {

            while(end<s.length() && !map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), end);
                ans = Math.max(end-start+1, ans);
                end++;
            }

            if(end==s.length()) {
                break;
            }

            int index = map.get(s.charAt(end));

            while(start<=index) {
                map.remove(s.charAt(start));
                start++;
            }
        }
        return ans;
    }

    // This method is very optimal, the first sliding window solution would be more practical
    public int lengthOfLongestSubstringTwo(String s) {

            if(s==null || s.length()==0) {
                return 0;
            }

            // j is used to track the nearest duplicate character's index
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
