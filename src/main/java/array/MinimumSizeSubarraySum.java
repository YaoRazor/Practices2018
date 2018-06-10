package array;

// Prerequisite: the elements fo this array most be positve
// All the optimal solution won't work, but the O(n^2) solution
// will still work
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {

        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int left = 0;


        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];

            while (sum>=s) {
                ans = Math.min(i-left+1, ans);
                sum-=nums[left++];
            }

        }

        if(Integer.MAX_VALUE == ans) {
            return 0;
        }

        return ans;
    }
}
