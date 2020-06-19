package advanced.chapterfive;


import java.util.Arrays;

public class HouseRobber {
    // TC: O(N), SC: O(1)
    public long rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        long dp[] = new long[3];

        dp[0] = 0;
        dp[1] = nums[0];

        for(int i=2; i<=nums.length; i++) {
            dp[i%3] = Math.max(dp[(i-2)%3]+nums[i-1], dp[(i-1)%3]);
        }

        return dp[nums.length%3];
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


    public int robAirbnb(int[] nums) {

        if(nums==null || nums.length==0) {
            return 0;
        }

        if(nums.length==1) {
            System.out.println(nums[0]);
            return nums[0];
        }

        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        Arrays.fill(pre, -1);

        dp[0] = nums[0];
        pre[0] = 0;

        dp[1] = Math.max(nums[1], nums[0]);

        if(dp[1] == nums[1]) {
            pre[1] = 1;
        }

        for(int i=2; i<nums.length; i++) {

            int cur = nums[i] + dp[i-2];

            if(cur > dp[i-1]) {

                dp[i] = cur;
                pre[i] = i-2;

            } else {

                dp[i] = dp[i-1];
            }

        }


        int index = nums.length-1;

        while(pre[index]!=index) {

            if(pre[index]==-1) {
                index--;
            } else {
                System.out.println(index+"\n");
                index = pre[index];
            }
        }

        System.out.println(index+"\n");

        return dp[nums.length-1];

    }

}
