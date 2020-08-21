package ninechapter.dfs.required;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    private static final List<String> phoneTab =
            Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits==null || digits.length()==0) {
            return ans;
        }

        dfs(ans, new StringBuilder(), 0, digits);
        return ans;
    }

    private void dfs(List<String> ans, StringBuilder sb, int index, String digits) {
        if(index==digits.length()) {
            ans.add(sb.toString());
            return;
        }

        char c = digits.charAt(index);
        String candidates = phoneTab.get(c-'2');

        for(char tmp: candidates.toCharArray()) {
            sb.append(tmp);
            dfs(ans, sb, index+1, digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
