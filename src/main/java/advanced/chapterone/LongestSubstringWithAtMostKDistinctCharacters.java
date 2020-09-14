package advanced.chapterone;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        int j = -1;

        for(int i=0; i<s.length(); i++) {
            while(cnt<=k && j+1<s.length()) {
                // Increment j first, this is key of this problem
                j++;
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0)+1);
                if(map.get(c)==1) {
                    cnt++;
                }
            }

            ans = Math.max(ans, j-i);
            if(j+1==s.length()) {
                if(cnt<=k) {
                    ans = Math.max(ans, j-i+1);
                }
                break;
            }

            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)-1);

            if(map.get(c)==0) {
                cnt--;
            }
        }

        return ans;
    }

    // similar to first solution except for every internal loop, we will run
    // ans = Math.max(j-i, ans), it is slightly less efficient than first
    // solution, however, it is more readable
    public int lengthOfLongestSubstringKDistinctTwo(String s, int k) {
        if(s==null || s.length()==0) {
            return 0;
        }

        int ans = 0;
        int cnt = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            while(cnt<=k && j<s.length()) {
                ans = Math.max(j-i, ans);
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0)+1);
                if(map.get(c)==1) {
                    cnt++;
                }
                j++;
            }
            if(j==s.length()) {
                if(cnt<=k) {
                    ans = Math.max(j-i, ans);
                }
                break;
            }

            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)-1);
            if(map.get(c)==0) {
                cnt--;
            }
        }

        return ans;
    }
}
