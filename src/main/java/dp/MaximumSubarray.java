package dp;

//O(n) time complexity and O(1) space complexity
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }

        int maximumEndingHere = nums[0];
        int ans = nums[0];

        for(int i=1; i<nums.length; i++) {

            maximumEndingHere = Math.max(maximumEndingHere+nums[i], nums[i]);
            ans = Math.max(maximumEndingHere, ans);
        }

        return ans;
    }
}
