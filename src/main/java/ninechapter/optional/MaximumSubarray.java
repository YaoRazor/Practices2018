package ninechapter.optional;

//O(n) time complexity and O(1) space complexity
public class MaximumSubarray {

    // This is still dp, but with optimization of rolling array
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

    public int maxSubArrayUsingDp(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        int ans = dp[0];

        for(int i=1; i<n; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
