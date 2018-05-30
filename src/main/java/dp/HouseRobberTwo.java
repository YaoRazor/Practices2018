package dp;


// The keypoint is the reduce the problem to a non-circular problem
public class HouseRobberTwo {
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        } else if(nums.length == 1) {
            return nums[0];
        } else {
            return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
        }

    }


    private int rob(int[] nums, int lo, int hi) {
        int prevMax = 0;
        int currMax = 0;
        for (int i=lo; i<=hi; i++) {
            int temp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
