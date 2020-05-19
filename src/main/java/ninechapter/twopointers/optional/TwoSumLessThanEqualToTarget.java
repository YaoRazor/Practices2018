package ninechapter.twopointers.optional;

import java.util.Arrays;

public class TwoSumLessThanEqualToTarget {
    public int twoSum5(int[] nums, int target) {
        if(nums==null || nums.length<2) {
            return 0;
        }

        Arrays.sort(nums);
        int ans = 0;
        int start = 0;
        int end = nums.length-1;

        while(start<end) {
            if(nums[start]+nums[end]>target) {
                end--;
            } else {
                ans += (end-start);
                start++;
            }
        }

        return ans;
    }
}
