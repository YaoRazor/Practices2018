package airbnb;


import java.util.Arrays;

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
