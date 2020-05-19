package ninechapter.dp_bottemup.optional;


public class JumpGame {

    // DP
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length == 0) {
            return false;
        }

        boolean[] canJump = new boolean[nums.length];
        canJump[0] = true;

        for(int i=0; i<nums.length; i++) {
            if (canJump[i]) {
                for (int j = 1; j <= nums[i] && i + j <= nums.length - 1; j++) {
                    canJump[i + j] = true;
                }
            } else {
                return false;
            }
        }

        return canJump[nums.length-1];
    }

    // BFS
    public boolean canJumpTwo(int[] nums) {
        if(nums==null || nums.length<2) {
            return true;
        }

        int n = nums.length;

        int curMax = 0;
        int i = 0;

        while(i<=curMax) {
            int nextMax = 0;
            while(i<=curMax) {
                nextMax = Math.max(nextMax, nums[i]+i);
                if(nextMax>=n-1) {
                    return true;
                }
                i++;
            }
            curMax = Math.max(curMax, nextMax);
        }

        return false;
    }
}
