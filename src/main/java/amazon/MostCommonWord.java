package amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {

        // "\\W+" 用来match所有non characters, 因为这一题还有标点符号需要handle
        String[] split = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");

        Set<String> set = new HashSet<>();

        for(String str: banned) {
            set.add(str);
        }

        Map<String, Integer> map = new HashMap<>() ;

        for(String str: split) {

            if(!set.contains(str)) {
                map.put(str, map.getOrDefault(str, 0)+1);
            }

        }

        String ans = "";
        int count = 0;

        for(String str: map.keySet()) {

            if(map.get(str)>count) {
                ans = str;
                count = map.get(str);
            }


        }

        return ans;

    }
}
