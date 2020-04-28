package ninechapter.dfs.required;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LetterCombinationsOfPhoneNumber {
    private static List<String> phoneTab =
            Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits==null || digits.length()==0) {
            return ans;
        }
        dfs(new StringBuilder(), 0, ans, digits);
        return ans;
    }

    private void dfs(StringBuilder cur, int index, List<String> ans, String digits) {
        if(index==digits.length()) {
            ans.add(cur.toString());
            return;
        }

        String potential = phoneTab.get(digits.charAt(index)-'0'-2);

        for(int i=0; i<potential.length(); i++) {
            cur.append(potential.charAt(i));
            dfs(cur, index+1, ans, digits);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
