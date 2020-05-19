package ninechapter.twopointers.optional;

import java.util.Arrays;

public class TwoSumUniquePairs {

    public int twoSum6(int[] nums, int target) {
        if(nums==null || nums.length<2) {
            return 0;
        }

        Arrays.sort(nums);

        int start = 0;
        int end = nums.length-1;
        int ans = 0;

        while(start<end) {
            if(nums[start]+nums[end]==target) {
                ans++;
                int left = nums[start];
                int right = nums[end];
                while(start<end && nums[start]==left) {
                    start++;
                }

                while(start<end && nums[end]==right) {
                    end--;
                }
            } else if(nums[start]+nums[end]>target) {
                end--;
            } else {
                start++;
            }
        }

        return ans;
    }
}
