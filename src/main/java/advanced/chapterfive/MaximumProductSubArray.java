package advanced.chapterfive;

public class MaximumProductSubArray {

    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }

        int min = nums[0];
        int max = nums[0];
        int ans = nums[0];

        for(int i=1; i<nums.length; i++) {
            if(nums[i]>0) {
                max = Math.max(max*nums[i], nums[i]);
                min = Math.min(nums[i], min*nums[i]);
            } else {
                int tmp = max;
                max = Math.max(min*nums[i], nums[i]);
                min = Math.min(tmp*nums[i], nums[i]);
            }

            ans = Math.max(max, ans);
        }

        return ans;
    }
}
