package dfs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Subsets {

    // Need to ask whether there are duplicates
    // We can use Subsets two as the sample program to solve this problem
    // Time complexity: O(2^n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if(nums==null || nums.length==0) {
            return ans;
        }

        LinkedList<Integer> cur = new LinkedList<>();
        backtrack(nums, 0, cur, ans);
        return ans;
    }

    private void backtrack(int[] nums, int start, LinkedList<Integer> cur, List<List<Integer>> ans) {

        ans.add(new LinkedList<>(cur));

        for(int i=start; i<nums.length; i++) {
            cur.add(nums[i]);
            // it is (i+1) here, not start+1
            backtrack(nums, i+1, cur, ans);
            cur.removeLast();
        }

    }
}