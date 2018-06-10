package dp;


public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }


        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int ans = dp[0];

        for(int i=1; i<nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
