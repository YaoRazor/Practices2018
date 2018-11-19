package dp;

public class BurstBalloons {


    // 这一题的关键点是两边各加一个1， 所以dp[i][j]的含义其实是吹爆i+1到j-1这些气球后得到的最大值
    public int maxCoins(int[] onums) {
        int[] nums = new int[onums.length+2];
        int n = 1;
        for(int tmp: onums) {
            nums[n++] = tmp;
        }

        nums[0] = nums[n++] = 1;
        int[][] dp = new int[n][n];
        return getCoins(nums, dp, 0, n-1);
    }

    private int getCoins(int[] nums, int[][] dp, int left, int right) {
        if(left+1==right) {
            return 0;
        }

        if(dp[left][right]>0) {
            return dp[left][right];
        }

        for(int i=left+1; i<right; i++) {
            dp[left][right] = Math.max(dp[left][right], nums[left]*nums[i]*nums[right] +
                    getCoins(nums, dp, left, i) + getCoins(nums, dp, i, right));
        }

        return dp[left][right];
    }
}
