package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsTwo {


    // Time complexity: O(2^n)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if(nums==null || nums.length==0) {
            return ans;
        }

        // key point
        Arrays.sort(nums);

        LinkedList<Integer> cur = new LinkedList<>();
        dfs(nums, 0, cur, ans);
        return ans;
    }

    private void dfs(int[] nums, int start, LinkedList<Integer> cur, List<List<Integer>> ans) {

        ans.add(new LinkedList<>(cur));

        for(int i=start; i<nums.length; i++) {
            cur.add(nums[i]);
            dfs(nums, i+1, cur, ans);
            cur.removeLast();
            // key point
            while (i+1<nums.length && nums[i+1] == nums[i]) {
                i++;
            }
        }

    }
}
