package array;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {

        if(num==null || num.length()==0) {
            return true;
        }

        Map<Character, Character> map = new HashMap<>();

        map.put('6', '9');
        map.put('9', '6');
        map.put('1', '1');
        map.put('8', '8');
        map.put('0', '0');

        int start = 0;
        int end = num.length()-1;

        while(start<end) {
            if(!map.containsKey(num.charAt(start)) || !map.get(num.charAt(start)).equals(num.charAt(end))) {
                return false;
            }

            start++;
            end--;

        }

        if(start==end) {
            return num.charAt(start)=='0' ||  num.charAt(start)=='1' || num.charAt(start)=='8';
        } else {
            return true;
        }

    }
}
