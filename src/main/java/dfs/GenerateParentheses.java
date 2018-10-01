package dfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        if(n<=0) {
            return ans;
        }

        StringBuilder sb = new StringBuilder();
        dfs(0, 0, sb, n, ans);

        return ans;

    }


    private void dfs(int left, int right, StringBuilder sb, int n, List<String> ans) {
        if(left==n && right==n) {
            ans.add(sb.toString());
            return;
        }

        if(left<n) {
            sb.append('(');
            dfs(left+1, right, sb, n, ans);
            sb.deleteCharAt(sb.length()-1);
        }


        if(left>right) {
            sb.append(')');
            dfs(left, right+1, sb, n, ans);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
