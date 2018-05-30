package dp;


public class HouseRobber {
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        }

        int dp[] = new int[nums.length+1];

        dp[0] = 0;
        dp[1] = nums[0];

        for(int i=2; i<=nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }

        return dp[nums.length];
    }


    public int robWithConstantSpaceComplexity(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }

}
