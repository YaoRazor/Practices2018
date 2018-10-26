package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsTwo {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        if (nums == null ) {
            return ans;
        }

        LinkedList<Integer> cur = new LinkedList<>();
        boolean[] isUsed = new boolean[nums.length];
        // Sorting is important
        Arrays.sort(nums);
        dfs(nums, isUsed, cur);
        return ans;

    }



    private void dfs(int[] nums, boolean[] isUsed, LinkedList<Integer> cur) {

        if(cur.size()==nums.length) {
            ans.add(new LinkedList<>(cur));
            return;
        }

        for(int i=0; i<nums.length; i++) {

            if(isUsed[i]==false) {
                cur.add(nums[i]);
                isUsed[i] = true;
                dfs(nums, isUsed, cur);
                cur.removeLast();
                isUsed[i] = false;
                // Key point
                while (i+1<nums.length && nums[i+1]==nums[i]) {
                    i++;
                }
            }


        }

    }
}
