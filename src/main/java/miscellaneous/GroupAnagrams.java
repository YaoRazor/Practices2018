package miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yawang on 4/18/18.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List<String>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++) {

            String sorted = sortString(strs[i]);

            if(!map.containsKey(sorted)) {
               map.put(sorted, new ArrayList<>());
            }

            map.get(sorted).add(strs[i]);

        }

        return new ArrayList<>(map.values());

    }


    protected String sortString(String input) {
        return Stream.of(input.split(""))
                      .sorted()
                      .collect(Collectors.joining());
    }


}
