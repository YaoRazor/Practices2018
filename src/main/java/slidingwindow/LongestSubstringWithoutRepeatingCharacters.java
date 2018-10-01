package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {


        if(s==null || s.length()==0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        int slow = 0; int fast = 0;
        int ans = 0;

        for(; fast<s.length(); fast++) {

            Character cur = s.charAt(fast);

            if(map.containsKey(cur)) {
                int index = map.get(cur);

                while (slow<=index) {
                    map.remove(s.charAt(slow));
                    slow++;
                }


            } else {
                ans = Math.max(ans, fast-slow+1);
            }

            map.put(cur, fast);

        }

        return ans;

    }
}
