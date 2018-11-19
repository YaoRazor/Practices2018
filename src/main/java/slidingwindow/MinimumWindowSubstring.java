package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    // 使用九章算法同向双指针模板
    public String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        String ans = "";

        for(char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int end = 0;
        // 用这个cnt来代表是不是满足了条件，是一个常见思路，可以参考FindAllAnagramsinSingleString
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
