package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LetterCombinationsOfPhoneNumber {
    List<String> ret = new ArrayList<>();
    public static final Map<Character, String> MAP = new HashMap<>();

    public List<String> letterCombinations(String digits) {

        if(digits == null || digits.length() == 0) {
            return ret;
        }

        StringBuilder sb = new StringBuilder();
                               MAP.put('3', "def");
                               MAP.put('2', "abc");
                               MAP.put('4', "ghi");
                               MAP.put('5', "jkl");
                               MAP.put('6', "mno");
                               MAP.put('7', "pqrs");
                               MAP.put('8', "tuv");
                               MAP.put('9', "wxyz");



        dfs(digits, 0, sb);
        return ret;
    }

    private void dfs(String digits, int start, StringBuilder cur) {

        if (start == digits.length()) {
            ret.add(cur.toString());
            return;
        }

        String mapping = MAP.get(digits.charAt(start));
        int length = mapping.length();

        for (int i = 0; i < length; i++) {
            cur.append(mapping.charAt(i));
            dfs(digits, start + 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
