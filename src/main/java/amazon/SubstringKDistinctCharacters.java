package amazon;

import java.util.*;
import java.util.stream.Collectors;

public class SubstringKDistinctCharacters {

    public List<String> findSubstringKDistinct(String s, int k) {

        if (s == null || k < 1) {
            return Collections.emptyList();
        }

        Map<Character, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        int end = 0;
        int start = 0;
        int cnt = 0;

        while(end<s.length()) {

            char c = s.charAt(end);

            if(!map.containsKey(c)) {
                cnt++;
            }

            map.put(c, map.getOrDefault(c, 0) + 1);


            if(end-start+1 == k) {

                if(cnt==k) {
                    set.add(s.substring(start, end+1));
                }

                c = s.charAt(start);

                map.put(c, map.get(c) -1);

                if(map.get(c) == 0) {
                    cnt--;
                    map.remove(c);

                }


                start++;
            }

            end++;



        }

        return set.stream().collect(Collectors.toList());
    }


}
