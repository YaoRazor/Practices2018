package ninechapter.dfs.optional;

import java.util.*;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        dfs(ans, cur, 1, n, k);

        return ans;
    }

    private void dfs(List<List<Integer>> ans, LinkedList<Integer> cur, int start, int n, int k) {
        if(cur.size()==k) {
            ans.add(new LinkedList<>(cur));
            return;
        }

        for(int i=start; i<=n; i++) {
            cur.add(i);
            dfs(ans, cur, i+1, n, k);
            cur.removeLast();
        }
    }
}
