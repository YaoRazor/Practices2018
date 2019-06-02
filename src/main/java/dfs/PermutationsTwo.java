package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsTwo {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null || nums.length==0) {
            return ans;
        }

        Arrays.sort(nums);
        LinkedList<Integer> tmp = new LinkedList<>();
        boolean[] isVisited = new boolean[nums.length];
        backtrack(ans, tmp, isVisited, nums);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, LinkedList<Integer> tmp, boolean[] isVisited, int[] nums) {

        if(tmp.size()==nums.length) {
            ans.add(new LinkedList<>(tmp));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!isVisited[i]) {
                isVisited[i]=true;
                tmp.add(nums[i]);
                backtrack(ans, tmp, isVisited, nums);
                tmp.removeLast();
                isVisited[i]=false;

                while(i+1<nums.length && nums[i+1]==nums[i]) {
                    i++;
                }
            }
        }
    }
}
