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
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;


        for(int i=0; i<nums.length; i++) {
            while(sum<s && j<nums.length) {
                sum+=nums[j++];
            }

            if(j==nums.length && sum<s) {
                break;
            }

            if(sum>=s) {
                ans = Math.min(j-i, ans);
            }

            ans = Math.min(j-i, ans);
            sum-=nums[i];
        }

        return ans==Integer.MAX_VALUE? -1:ans;
    }
}
