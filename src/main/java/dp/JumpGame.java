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
            } else {
                return false;
            }

        }


        return canJump[nums.length-1];

    }


    //For this problem, I think Greedy is actually not as important as dp
    public boolean canJumpTwo(int[] nums) {

        if(nums==null || nums.length == 0) {
            return false;
        }

        int lastSeen = 0;
        int start = 0;

        while(start<=lastSeen && start<nums.length) {

            for(int i=start; i<=lastSeen; i++) {
                lastSeen = Math.max(lastSeen, nums[i]+i);

                if(lastSeen>=nums.length-1) {
                    return true;
                }
            }

            start = start+1;

        }

        return false;
    }
}
