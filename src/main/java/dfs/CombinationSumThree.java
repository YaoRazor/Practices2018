package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumThree {
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        dfs(k, 1, cur, ans, target);
        return ans;
    }

    private void dfs(int k, int start, LinkedList<Integer> cur, List<List<Integer>> ans, int target) {
        if(cur.size()==k) {
            if(target==0) {
                ans.add(new LinkedList<>(cur));
            }
            return;
        }

        for(int i=start; i<10; i++) {
            if(i>target) {
                return;
            }

            cur.add(i);
            dfs(k, i+1, cur, ans, target-i);
            cur.removeLast();
        }
    }
}
