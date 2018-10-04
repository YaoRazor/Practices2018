package dropbox;

import java.util.HashMap;
import java.util.Map;

public class WordPatternTwo {
    public boolean wordPatternMatch(String pattern, String str) {

        if(pattern==null || str==null) {
            return false;
        }

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        return wordPatternMatch(pattern, str, 0, 0, map1, map2);


    }


    // i is the startPoint in the pattern and j is the startPoint in the string to match
    private boolean wordPatternMatch(String pattern, String str, int i, int j, Map<Character, String> map1, Map<String, Character> map2) {

        if(i==pattern.length() && j==str.length()) {
            return true;
        } else if(i==pattern.length() || j==str.length()) {
            return false;
        }

        Character cur = pattern.charAt(i);

        if(map1.containsKey(cur)) {

            String mappedString = map1.get(cur);

            if(j+mappedString.length()>str.length()) {
                return false;
            }


            if(!str.substring(j, j+mappedString.length()).equals(mappedString)) {
                return false;
            } else {
                return wordPatternMatch(pattern, str, i+1, j+mappedString.length(), map1, map2);
            }


        } else {

            // Try to create a new mapping
            for(int k = j+1; k<=str.length(); k++) {

                String subString = str.substring(j, k);

                if(map2.containsKey(subString)) {
                    continue;
                } else {


                    map1.put(cur, subString);
                    map2.put(subString, cur);

                    if(wordPatternMatch(pattern, str, i+1, k, map1, map2)) {
                        return true;
                    }

                    map1.remove(cur);
                    map2.remove(subString);

                }


            }

            return false;

        }

    }
}
