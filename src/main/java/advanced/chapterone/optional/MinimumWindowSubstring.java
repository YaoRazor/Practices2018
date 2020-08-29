package advanced.chapterone.optional;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if(s==null || t==null || s.length()<t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        // 可以不要ans，直接用s.substring()函数，code会简单一些，但是
        // 算法复杂度会高一些
        int[] ans = new int[2];
        int cnt = Integer.MAX_VALUE;

        int start = 0;
        int k = 0;

        for(int end=0; end<s.length(); end++) {
            char c = s.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if(map.get(c)==0) {
                    k++;
                }
            }

            while(k==map.size()) {
                if(end-start+1<cnt) {
                    ans[0] = start;
                    ans[1] = end;
                    cnt = end-start+1;
                }

                char tmp = s.charAt(start);
                if(map.containsKey(tmp)) {
                    map.put(tmp, map.get(tmp)+1);
                    if(map.get(tmp)==1) {
                        k--;
                    }
                }

                start++;
            }
        }

        if(cnt==Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(ans[0], ans[1]+1);
        }
    }
}
