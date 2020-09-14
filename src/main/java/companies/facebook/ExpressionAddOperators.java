package companies.facebook;

import java.util.*;

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        dfs(ans, "", num, 0, target, 0, 0);
        return ans;
    }

    private void dfs(List<String> ans, String path, String num, int index, int target, long eval, long multi) {
        if (index == num.length()) {
            if (eval == target) {
                ans.add(path);
            }

            return;
        }

        for (int i = index + 1; i <= num.length(); i++) {
            if (i != index + 1 && num.charAt(index) == '0') {
                break;
            }

            long cur = Long.parseLong(num.substring(index, i));
            if (index == 0) {
                dfs(ans, path + cur, num, i, target, eval + cur, cur);
            } else {
                dfs(ans, path + "+" + cur, num, i, target, eval + cur, cur);
                dfs(ans, path + "-" + cur, num, i, target, eval - cur, -cur);
                dfs(ans, path + "*" + cur, num, i, target, eval - multi + multi * cur, multi * cur);
            }
        }
    }
}