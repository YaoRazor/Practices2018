package companies.facebook;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        if(words==null || words.length<2) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for(int i=0; i<words.length-1; i++) {
            String first = words[i];
            String second = words[i+1];

            for(int j=0; j<first.length() && j<second.length(); j++) {
                if(first.charAt(j)==second.charAt(j)) {
                    if((j+1==second.length()) && first.length()>second.length()) {
                        return false;
                    }

                    continue;
                }

                if(map.get(first.charAt(j))>map.get(second.charAt(j))) {
                    return false;
                } else {
                    break;
                }
            }
        }

        return true;
    }
}
