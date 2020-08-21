package companies.facebook;

import java.util.*;

public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<>();
        if(strings==null || strings.length==0) {
            return ans;
        }


        Map<String, List<String>> map = new HashMap<>();

        for(String str: strings) {
            String key = convertToMapping(str);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        for(String key: map.keySet()) {
            ans.add(map.get(key));
        }

        return ans;
    }

    private String convertToMapping(final String input) {
        if(input.length()==1) {
            return "a";
        }

        int offset = input.charAt(0)-'a';
        StringBuilder sb = new StringBuilder();
        sb.append('a');

        for(int i=1; i<input.length(); i++) {
            char c = input.charAt(i);
            int cur = c-'a';
            cur-=offset;
            if(cur<0) {
                cur +=26;
            }

            sb.append((char)(cur+'a'));
        }

        return sb.toString();
    }
}
