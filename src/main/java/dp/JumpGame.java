package dp;


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

    public boolean canJumpTwo(int[] nums) {

        int curMax = 0;

        for(int i=0; i<nums.length && i<=curMax; i++) {

            curMax = Math.max(i+nums[i], curMax);
            if(curMax>=nums.length-1) {
                return true;
            }
        }

        return false;
    }
}
