package advanced.chapterone;

// Prerequisite: the elements fo this array must be positve
public class MinimumSizeSubarraySum {

    // Use right pointer as main pointer
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
            return -1;
        }

        return ans;
    }


    // Use left pointer as main pointer
    public int minimumSize(int[] nums, int s) {
        // write your code here
        int j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {

            while(j<nums.length && sum<s) {
                sum+=nums[j];
                j++;
            }

            if(sum>=s) {
                ans = Math.min(ans, j-i);
            } else if(j==nums.length) {
                break;
            }

            sum-=nums[i];
        }

        return ans==Integer.MAX_VALUE? -1: ans;
    }
}
