package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        dfs(candidates, 0, cur, ans, target);
        return ans;
    }

    private void dfs(int[] candidates, int start, LinkedList<Integer> cur, List<List<Integer>> ans, int target) {
        if(target==0) {
            ans.add(new LinkedList<>(cur));
            return;
        }

        // This for loop can be viewed as traversal of N-ary tree
        for(int i=start; i<candidates.length; i++) {
            if(candidates[i]>target) {
                return;
            }

            cur.add(candidates[i]);
            dfs(candidates, i, cur, ans, target-candidates[i]);
            cur.removeLast();
        }
    }
}
