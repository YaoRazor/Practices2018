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

        int min = Integer.MAX_VALUE;
        String ans = "";
        int cnt = 0;

        int j = 0;
        for(int i=0; i<s.length(); i++) {
            //先算i，再算j，否则会漏解
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if(map.get(c)==0) {
                    cnt++;
                }
            }
            while(cnt==map.size()) {
                if(i-j+1<min) {
                    min = i-j+1;
                    ans = s.substring(j, i+1);
                }
                char tmp = s.charAt(j);
                if(map.containsKey(tmp)) {
                    map.put(tmp, map.get(tmp)+1);
                    if(map.get(tmp)==1) {
                        cnt--;
                    }
                }
                j++;
            }
        }

        return ans;
    }
}
