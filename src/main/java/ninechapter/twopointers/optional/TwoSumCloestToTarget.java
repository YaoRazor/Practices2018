package ninechapter.twopointers.optional;

import java.util.Arrays;

public class TwoSumCloestToTarget {
    public int twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int difference = Integer.MAX_VALUE;

        int start = 0;
        int end = nums.length-1;

        while(start<end) {
            int sum = nums[start]+nums[end];

            if(sum==target) {
                return 0;
            } else if(nums[start]+nums[end]>target) {
                difference = Math.min(sum-target, difference);
                end--;
            } else {
                difference = Math.min(target-sum, difference);
                start++;
            }
        }

        return difference;
    }
}
