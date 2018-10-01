package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        LinkedList<Integer> cur = new LinkedList<>();
        dfs(1, n, k, cur);
        return ans;
    }



    private void dfs(int start, int n, int k, LinkedList<Integer> cur) {

        if(cur.size()==k) {
            ans.add(new LinkedList<>(cur));
            return;
        }


        for(int i=start; i<=n; i++) {
            cur.add(i);
            dfs(i+1, n, k, cur);
            cur.removeLast();
        }
    }
}
