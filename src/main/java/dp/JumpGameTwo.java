package dp;


public class JumpGameTwo {
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


    public int jumpGreedy(int[] nums) {
        int ret = 0;
        int lastFurthest = 0;
        int furthest = 0;

        for(int i=0; i<nums.length; i++) {

            if(i>furthest) {
                return Integer.MAX_VALUE;
            }

            if(i>lastFurthest) {
                ret++;
                lastFurthest = furthest;
            }

            furthest = Math.max(furthest, nums[i]+i);
        }

        return ret;
    }
}
