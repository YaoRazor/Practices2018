package dfs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Subsets {

    // Consider this as a binary tree, every node denotes whether to choose current number or not
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null || nums.length==0) {
            return ans;
        }

        Arrays.sort(nums);
        LinkedList<Integer> tmp = new LinkedList<>();
        backtrack(ans, tmp, 0, nums);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, LinkedList<Integer> tmp, int i, int[] nums) {

        if(i==nums.length) {
            ans.add(new LinkedList<>(tmp));
            return;
        }

        tmp.add(nums[i]);

        backtrack(ans, tmp, i+1, nums);
        tmp.removeLast();
        // while(i+1<nums.length && nums[i+1]==nums[i]) {
        //     i++;
        // }
        backtrack(ans, tmp, i+1, nums);
    }
}