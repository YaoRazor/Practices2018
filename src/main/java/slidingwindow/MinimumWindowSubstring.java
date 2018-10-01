package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for(char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }


        int slow = 0, fast = 0, ans = Integer.MAX_VALUE, max_count = 0; int index = 0;

        for(;fast < s.length(); fast++) {

            Character cur = s.charAt(fast);

            if(!map.containsKey(cur)) {
                continue;
            } else {
                map.put(cur, map.get(cur)-1);

                if(map.get(cur)==0) {

                    max_count++;

                    // max_count==map.size(), this is the key point of this item
                    while (slow<=fast && max_count==map.size()) {

                        if(fast-slow+1<ans) {
                            ans = fast-slow+1;
                            index = slow;
                        }


                        if(map.containsKey(s.charAt(slow))) {
                            map.put(s.charAt(slow), map.get(s.charAt(slow))+1);
                            if(map.get(s.charAt(slow))==1) {
                                max_count--;
                            }
                        }

                        slow++;

                    }

                }

            }

        }


        return ans==Integer.MAX_VALUE? "": s.substring(index, index+ans);


    }
}
