package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinaString {

    // 本题的解法是Sliding window
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        if(s==null || s.length() < p.length()) {
            return ans;
        }

        for(char c: p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int end = 0;
        int cnt = map.size();

        while(end< s.length()) {
            Character cur = s.charAt(end);
            if(map.containsKey(cur)) {
                map.put(cur, map.get(cur)-1);

                // map.get(cur)可以是负的，但是只有在从1变成0或者像54行那样从0变成1的时候才是一个状态的改变
                // map.get(cur)是负的只说明现在的substring里有多余的p含有的character
                if(map.get(cur)==0) {
                    cnt--;
                }
            }

            // 只要cnt==0, 说明现在的window里包含了所有p的元素
            while(cnt==0) {
                // 这是另一个条件，当包含了所有的元素的时候，长度又相等，说明了现在的substring和p是anagram
                if(end-start+1==p.length()) {
                    ans.add(start);
                }

                cur = s.charAt(start);
                if(map.containsKey(cur)) {
                    map.put(cur, map.get(cur)+1);
                    if(map.get(cur)>0) {
                        cnt++;
                    }
                }

                start++;
            }

            end++;
        }

        return ans;
    }
}
