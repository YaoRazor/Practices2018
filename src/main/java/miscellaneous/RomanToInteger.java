package miscellaneous;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yawang on 4/7/18.
 */
public class RomanToInteger {

    private Map<Character, Integer> romanMap = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);

    }};

    public int romanToInt(String s) {
        if(s==null || s.length()==0) {
            return 0;
        }

        int sum = 0;


        for(int i=0; i<s.length(); i++) {

            sum += romanMap.get(s.charAt(i));

            if(i>=1 && romanMap.get(s.charAt(i)) > romanMap.get(s.charAt(i-1))) {
                sum -= 2 * romanMap.get(s.charAt(i-1));
            }

        }

        return sum;
    }
}
