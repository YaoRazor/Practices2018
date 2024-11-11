package ninechapter.warmup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if(s==null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) +1);
        }

        int cnt = 0;

        for (Character key : map.keySet()) {

            if(map.get(key) %2==0)  {
                cnt+=map.get(key);
            } else {
                cnt+=map.get(key)-1;
            }
        }

        // There is an edge case here, which is that there is even number of
        // characters in the string, in this case, we can not use cnt+1 anymore
        // because it can surpass the total number of characters in the string
        return Math.min(cnt+1, s.length());

        // Alternatively if below is easier to understand
//        if(s.length()>cnt) {
//            return cnt+1;
//        } else {
//            return cnt;
//        }
    }

    // This is simplified version of the first algorithm, but the
    // underlying reasoning is similar
    public int longestPalindromeTwo(String s) {
        // Write your code here
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }

        int remove = set.size();
        if (remove > 0)
            remove -= 1;
        return s.length() - remove;
    }
}
