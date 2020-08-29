package dfs;

import java.util.ArrayList;
import java.util.List;


public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        if(s==null || s.length()==0) {
            return ans;
        }

        dfs(ans, new StringBuilder(), 0, s);
        return ans;
    }

    private void dfs(List<String> ans, StringBuilder sb, int index, String s) {
        if(index==s.length()) {
            ans.add(sb.toString());
            return;
        }

        char c = s.charAt(index);
        if(Character.isDigit(c)) {
            sb.append(c);
            dfs(ans, sb, index+1, s);
            sb.deleteCharAt(sb.length()-1);
        } else {
            sb.append(Character.toLowerCase(c));
            dfs(ans, sb, index+1, s);
            sb.deleteCharAt(sb.length()-1);
            sb.append(Character.toUpperCase(c));
            dfs(ans, sb, index+1, s);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
