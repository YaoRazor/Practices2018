package ninechapter.twopointers.optional;

import java.util.Arrays;

public class TwoSumGreaterThanTarget {
    public int twoSum2(int[] nums, int target) {
        if(nums==null || nums.length<2) {
            return 0;
        }

        Arrays.sort(nums);

        int l = 0;
        int r = nums.length-1;
        int ans = 0;

        while(l<r) {

            if(nums[l]+nums[r]<=target) {
                l++;
            } else {
                ans+=r-l;
                r--;
            }

        }

        return ans;
    }
}
