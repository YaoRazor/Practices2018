package slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        if(s == null || s.length() == 0) {
            return 0;
        }

        int index = 0;
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i< s.length(); i++) {

            Character cur = s.charAt(i);

            if(map.containsKey(cur) || map.size()<2) {
                map.put(cur, i);
            } else {
                int smaller = s.length();
                Character old = null;
                for(Character key :map.keySet()) {
                    if(map.get(key)<smaller) {
                        old = key;
                        smaller = map.get(key);
                    }

                }

                map.remove(old);

                index = smaller+1;
                map.put(cur,1);

            }

            ans = Math.max(i-index+1, ans);


        }

        return ans;


    }
}
