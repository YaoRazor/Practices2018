package miscellaneous;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if(strs==null || strs.length==0) {
            return ans;
        }

        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {

            String sortedString = getSortedString(str);
            if(map.containsKey(sortedString)) {
                map.get(sortedString).add(str);

            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                map.put(sortedString, tmp);
            }
        }

        for(String key: map.keySet()) {
            ans.add(map.get(key));
        }

        return ans;

    }

    private String getSortedString(final String input) {
        char[] sortedCharArray = input.toCharArray();
        Arrays.sort(sortedCharArray);
        return String.valueOf(sortedCharArray);
    }


}
