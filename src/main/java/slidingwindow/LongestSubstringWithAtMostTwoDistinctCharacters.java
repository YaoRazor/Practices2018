package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {


    // 采用了九章算法强化班的同向双指针模板，可以扩展到K个的情况
    public int lengthOfLongestSubstringTwoDistinctTwo(String s) {
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0; i<s.length(); i++) {
            while(j<s.length() && map.size()<=2) {
                char c = s.charAt(j);

                if(!map.containsKey(c) && map.size()==2) {
                    map.put(c, 1);
                    j++;
                    break;
                }

                map.put(c, map.getOrDefault(c, 0)+1);

                ans = Math.max(ans, j-i+1);
                j++;

            }

            char cur = s.charAt(i);

            map.put(cur, map.get(cur)-1);
            if(map.get(cur) == 0) {
                map.remove(cur);
            }
        }

        return ans;
    }

}
