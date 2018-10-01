package array;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {

        if(s==null || s.length()==0) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<>();

        int cnt = 0;

        for(int i=0; i<s.length(); i++) {
            Character cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0)+1);

            if(map.get(cur)%2==0) {
                cnt--;
            } else {
                cnt++;
            }

        }

        return cnt<=1;

    }

}
