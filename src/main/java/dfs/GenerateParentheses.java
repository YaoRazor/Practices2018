package dfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if(n<=0) {
            return ans;
        }

        dfs(ans, new StringBuilder(), n, n);

        return ans;
    }

    private void dfs(List<String> ans, StringBuilder sb, int open, int close) {
        if(open==0 && close==0) {
            ans.add(sb.toString());
            return;
        }

        if(open>0) {
            sb.append('(');
            dfs(ans, sb, open-1, close);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close>open) {
            sb.append(')');
            dfs(ans, sb, open, close-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
