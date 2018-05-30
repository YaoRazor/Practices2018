package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yawang on 3/11/18.
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {

        List<String> ret = new ArrayList<>();
        if(S == null || S.length() == 0) {
            return ret;
        }

        StringBuilder sb = new StringBuilder();
        dfs(S, 0, ret, sb);

        return ret;
    }


    private void dfs(String S, int start, List<String> ret, StringBuilder sb) {
        if(start == S.length()) {
            ret.add(sb.toString());
            return;
        }

        Character c = S.charAt(start);


        if(Character.isLetter(c)) {
            sb.append(Character.toLowerCase(c));
            dfs(S, start+1, ret, new StringBuilder(sb));
            sb.deleteCharAt(sb.length()-1);
            sb.append(Character.toUpperCase(c));
            dfs(S, start+1, ret, new StringBuilder(sb));
        } else {
            sb.append(c);
            dfs(S, start+1, ret, sb);
        }

    }
}
