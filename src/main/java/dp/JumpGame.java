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

            if(canJump[i]) {

                for(int j=1; j<=nums[i] && i+j<=nums.length-1; j++) {
                    canJump[i+j] = true;
                }
            }

        }


        return canJump[nums.length-1];

    }


    //Greedy
    public boolean canJumpTwo(int[] nums) {

        int lastSeen = 0;

        int start=0;

        while ( start <nums.length && start<=lastSeen) {
            lastSeen = Math.max(nums[start]+start, lastSeen);

            if(lastSeen>=nums.length-1) {
                return true;
            }

            start++;
        }

        return false;
    }
}
