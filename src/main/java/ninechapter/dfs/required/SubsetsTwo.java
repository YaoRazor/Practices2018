package ninechapter.dfs.required;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsTwo {

    // Time complexity: O(2^n)
    // Consider this as a binary tree, every node denotes whether to choose current number or not
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null) {
            return ans;
        }

        Arrays.sort(nums);
        LinkedList<Integer> tmp = new LinkedList<>();
        dfs(ans, tmp, 0, nums);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, LinkedList<Integer> tmp, int i, int[] nums) {
        if(i==nums.length) {
            ans.add(new LinkedList<>(tmp));
            return;
        }

        tmp.add(nums[i]);
        dfs(ans, tmp, i+1, nums);
        tmp.removeLast();
        // This is the only difference between subset one and subset two
        while(i+1<nums.length && nums[i+1]==nums[i]) {
            i++;
        }
        dfs(ans, tmp, i+1, nums);
    }
}
