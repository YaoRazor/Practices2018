package ninechapter.dfs.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsTwo {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null) {
            return ans;
        }

        Arrays.sort(nums);
        LinkedList<Integer> cur = new LinkedList<>();

        boolean[] visited = new boolean[nums.length];
        dfs(ans, cur, nums, visited);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, LinkedList<Integer> cur, int[] nums,  boolean[] visited) {
        if(cur.size()==nums.length) {
            ans.add(new LinkedList<>(cur));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(visited[i]) {
                continue;
            }

            visited[i] = true;
            cur.add(nums[i]);
            dfs(ans, cur, nums, visited);
            visited[i] = false;
            cur.removeLast();

            while(i+1<nums.length && nums[i+1]==nums[i]) {
                i++;
            }
        }

    }
}
