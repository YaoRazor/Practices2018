package ninechapter.twopointers.optional;

public class WindowSum {

    // For this kind of easy problems, the key point is to understand
    // what those edge cases are and how we should handle them
    public int[] winSum(int[] nums, int k) {
        if(nums==null || nums.length==0 || nums.length-k+1<=0) {
            return new int[]{};
        }

        int[] ans = new int[nums.length-k+1];
        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            if(i<k-1) {
                sum+=nums[i];
            } else {
                sum+=nums[i];
                ans[i-k+1] = sum;
                sum-=nums[i-k+1];
            }
        }

        return ans;
    }
}
