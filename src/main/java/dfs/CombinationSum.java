package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> ans = new ArrayList<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        LinkedList<Integer> cur = new LinkedList<>();

        Arrays.sort(candidates);

        dfs(candidates, 0, target, cur);


        return ans;
    }



    private void dfs(int[] candidates, int start, int target, LinkedList<Integer> cur) {

        for(int i=start; i<candidates.length; i++) {

            if(candidates[i]>target) {
                return;
            }
            cur.add(candidates[i]);

            if(target-candidates[i] == 0) {
                ans.add(new ArrayList<>(cur));
                cur.removeLast();
                return;
            }

            dfs(candidates, start, target-candidates[i], cur);
            cur.removeLast();
        }

    }
}
