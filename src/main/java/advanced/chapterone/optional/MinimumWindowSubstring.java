package advanced.chapterone.optional;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int cnt = map.size();
        int j = 0;
        int ans = s.length()+1;
        String ret = "";

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if(map.get(c)==0) {
                    cnt--;
                    // System.out.println("cnt: "+cnt+" i: "+i+ " j: "+j);
                    while(cnt==0) {
                        char tmp = s.charAt(j);
                        if(map.containsKey(tmp)) {
                            map.put(tmp, map.get(tmp)+1);
                            if(map.get(tmp)==1) {
                                cnt++;
                                if(cnt==1) {
                                    if(ans>i-j+1) {
                                        ans = i-j+1;
                                        ret = s.substring(j, i+1);
                                    }
                                }
                            }
                        }
                        j++;
                    }
                }
            }
        }

        return ret;
    }
}
