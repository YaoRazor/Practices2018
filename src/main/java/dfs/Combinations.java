package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        dfs(n, 1, cur, ans, k);
        return ans;
    }

    private void dfs(int n, int start, LinkedList<Integer> cur, List<List<Integer>> ans, int k) {

        if(cur.size()==k) {
            ans.add(new LinkedList<>(cur));
            return;
        }

        for(int i=start; i<=n; i++) {
            cur.add(i);
            dfs(n, i+1, cur, ans, k);
            cur.removeLast();
        }
    }
}
