package slidingwindow;

public class MinimumSizeSubarraySum {

    // 又一个同向双指针问题
    public int minSubArrayLen(int s, int[] nums) {

        if(nums==null) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        int sum = 0;

        while(end< nums.length) {

            sum+=nums[end];

            while(sum>=s) {
                ans = Math.min(ans, end-start+1);
                sum-=nums[start];
                start++;
            }

            end++;

        }

        return ans==Integer.MAX_VALUE? 0: ans;

    }
}
