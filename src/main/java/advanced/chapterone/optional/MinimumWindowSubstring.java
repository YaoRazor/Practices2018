package advanced.chapterone.optional;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    // 这是一道稍微有所变化的Sliding Window，就是说两个指针都是
    // while循环，一般主指针是for循环，辅指针是while循环，所以
    // 说面试的时候遇到题目也要灵活，不要拘泥于模板
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        String ans = "";

        for(char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int end = 0;
        // extra variable to track state
        int cnt = map.size();
        int minimumWindowLength = Integer.MAX_VALUE;

        while(end< s.length()) {
            Character cur = s.charAt(end);

            if(map.containsKey(cur)) {
                map.put(cur, map.get(cur)-1);
                if(map.get(cur)==0) {
                    cnt--;
                }
            }

            // cnt等于0表示满足了条件
            while(cnt==0) {
                if(end-start+1<minimumWindowLength) {
                    ans = s.substring(start, end+1);
                    minimumWindowLength = end-start+1;
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

        return minimumWindowLength==Integer.MAX_VALUE? "" : ans;
    }
}
