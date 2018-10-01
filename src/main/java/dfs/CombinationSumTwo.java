package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumTwo {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        LinkedList<Integer> cur = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, cur);

        return ans;
    }



    private void dfs(int[] candidates, int start, int target, LinkedList<Integer> cur) {

        if(target==0) {
            ans.add(new LinkedList<>(cur));
            return;
        }

        for(int i=start; i<candidates.length; i++) {

            if(candidates[i]>target) {
                return;
            }

            cur.add(candidates[i]);
            dfs(candidates, i+1, target-candidates[i], cur);
            cur.removeLast();

            // Key point to remove duplicates
            while (i+1<candidates.length && candidates[i+1]==candidates[i]) {
                i++;
            }
        }

    }
}
