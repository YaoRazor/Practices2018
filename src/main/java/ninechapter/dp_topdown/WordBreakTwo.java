package ninechapter.dp_topdown;

import java.util.List;
import java.util.*;

public class WordBreakTwo {
    public List<String> wordBreak(String s, Set<String> dict) {
        if(dict==null || dict.isEmpty() || s==null || s.length()==0) {
            return new ArrayList<>();
        }

        Map<Integer, List<String>> dp = new HashMap<>();
        int maxLength = getMaxLength(dict);
        return numberOfBreak(s, 0, dict, dp, maxLength);
    }

    private List<String> numberOfBreak(String s, int start, Set<String> dict, Map<Integer, List<String>> dp, int maxLength) {
        if(dp.containsKey(start)) {
            return dp.get(start);
        }

        if(start==s.length()) {
            List<String> list = new ArrayList<>();
            list.add("");
            dp.put(start, list);
            return dp.get(start);
        }

        List<String> cur = new ArrayList<>();

        for(int i=start+1; i<=s.length() && i<=start+maxLength; i++) {
            String tmp = s.substring(start, i);
            if(!dict.contains(tmp)) {
                continue;
            }

            List<String> list = numberOfBreak(s, i, dict, dp, maxLength);
            for(String subString: list) {
                String newString;
                if(subString.length()!=0) {
                    newString = tmp + " " + subString;
                } else {
                    newString = tmp;
                }

                cur.add(newString);
            }
        }
        dp.put(start, cur);
        return cur;
    }

    private int getMaxLength(Set<String> dict) {
        int size = 0;

        for(String tmp: dict) {
            size = Math.max(size, tmp.length());
        }

        return size;
    }
}
