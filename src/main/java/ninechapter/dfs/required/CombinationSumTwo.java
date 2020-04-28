package ninechapter.dfs.required;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumTwo {

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null || nums.length==0) {
            return ans;
        }

        Arrays.sort(nums);
        LinkedList<Integer> cur = new LinkedList<>();
        dfs(ans, cur, 0, target, nums);
        return ans;
    }


    private void dfs(List<List<Integer>> ans, LinkedList<Integer> cur, int index, int target, int[] nums) {
        if(target==0) {
            ans.add(new LinkedList<>(cur));
            return;
        }

        for(int i=index; i<nums.length; i++) {
            if(nums[index]>target) {
                return;
            }

            cur.add(nums[i]);
            dfs(ans, cur, i+1, target-nums[i], nums);
            cur.removeLast();

            while(i+1<nums.length && nums[i+1]==nums[i]) {
                i++;
            }
        }

    }
}
