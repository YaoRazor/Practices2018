package dfs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Subsets {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        if(nums==null || nums.length==0) {
            return result;
        }

        LinkedList<Integer> cur = new LinkedList<>();
        dfs(nums, 0, cur);
        return result;
    }

    private void dfs(int[] nums, int start, LinkedList<Integer> cur) {

        if(start == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[start]);
        dfs(nums, start+1, cur);
        cur.removeLast();
        dfs(nums, start+1, cur);
    }
}