package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            return ans;
        }

        LinkedList<Integer> cur = new LinkedList<>();
        boolean[] isUsed = new boolean[nums.length];
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
            }
        }

    }
}
