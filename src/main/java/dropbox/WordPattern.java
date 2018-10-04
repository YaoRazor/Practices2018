package dropbox;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        String[] token = str.split("\\s+");

        if(token.length!=pattern.length()) {
            return false;
        }


        for(int i=0; i<token.length; i++) {

            Character cur = pattern.charAt(i);

            if(map1.containsKey(cur)) {

                if(!token[i].equals(map1.get(cur))) {
                    return false;
                }
            } else {

                if(map2.containsKey(token[i])) {
                    return false;
                }

                map1.put(cur, token[i]);
                map2.put(token[i], cur);

            }

        }

        return true;

    }
}
