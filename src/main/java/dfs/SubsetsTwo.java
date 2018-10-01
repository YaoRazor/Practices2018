package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsTwo {


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if(nums==null) {
            return ans;
        }

        LinkedList<Integer> cur = new LinkedList<>();

        Arrays.sort(nums);
        dfs(ans, cur, 0, nums);

        return ans;

    }



    private void dfs(List<List<Integer>> ans, LinkedList<Integer> cur, int pos, int[] nums) {

        if(pos==nums.length) {
            ans.add(new LinkedList<>(cur));
            return;
        }


        cur.add(nums[pos]);
        dfs(ans, cur, pos+1, nums);
        cur.removeLast();
        dfs(ans, cur, pos+1, nums);

        while (pos+1<nums.length && nums[pos+1] == nums[pos]) {
            pos++;
        }

    }
}
