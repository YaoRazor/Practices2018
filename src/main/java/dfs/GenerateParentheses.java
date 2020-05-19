package dfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void dfs(List<String> ans, StringBuilder sb, int left, int right, int n) {
        if(left==right && left==n) {
            ans.add(sb.toString());
            return;
        }

        if(left<n) {
            sb.append('(');
            dfs(ans, sb, left+1, right, n);
            sb.deleteCharAt(sb.length()-1);
        }

        if(right<left) {
            sb.append(')');
            dfs(ans, sb, left, right+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
