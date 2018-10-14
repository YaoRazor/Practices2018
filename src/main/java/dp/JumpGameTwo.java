package dp;


public class JumpGameTwo {

    // This is using DP
    public int jump(int[] nums) {

        int[] dp = new int[nums.length];

        for(int i=1; i<nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for(int i=0; i<nums.length; i++) {

            for(int j=1; j<=nums[i] && i+j<=nums.length-1; j++) {
                dp[i+j] = Math.min(dp[i]+1, dp[i+j]);
            }

        }

        return dp[nums.length-1];

    }


    // Greedy is not very straightforward, using BFS makes it much clear
    public int jumpBFS(int[] nums) {
        if(nums.length<2) {
            return 0;
        }

        int i = 0;
        int curMax =0;
        int level = 0;

        while(i<=curMax) {
            int nextMax = 0;
            level++;
            for(; i<=curMax; i++) {
                nextMax = Math.max(nextMax, nums[i]+i);

                if(nextMax>=nums.length-1) {
                    return level;
                }
            }

            curMax = nextMax;

        }

        return -1;
    }
}
