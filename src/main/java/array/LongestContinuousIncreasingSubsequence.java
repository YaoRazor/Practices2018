package array;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }

        int ans = 1;
        int start = 0;


        for(int i=1; i<nums.length; i++) {

            if(nums[i]>nums[i-1]) {
                continue;
            } else {

                ans = Math.max(i-start+1, ans);
                start = i;
            }

        }

        return ans;

    }
}
