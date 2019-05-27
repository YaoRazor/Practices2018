package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequences {
    public int lengthOfLISDP(int[] nums) {

        if(nums==null || nums.length==0) {
            return 0;
        }

        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;

        for(int i=1; i<n; i++) {

            for(int j=0; j<i; j++) {

                if(nums[j]<nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);

                }

            }
            ans = Math.max(dp[i], ans);

        }

        return ans;

    }

    // This function is nlog(n), this is really tricky
    // you can refer: https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
    // and https://segmentfault.com/a/1190000003819886
    public int lengthOfLISBinary(int[] nums) {

        if(nums==null || nums.length==0) {
            return 0;
        }

        int[] dp = new int[nums.length];

        int size = 0;

        for(int num: nums) {
            int i=0, j=size;

            while(i<j) {
                int mid = (i+j)/2;

                if(num > dp[mid]) {
                    i = mid+1;
                } else {
                    j= mid;
                }
            }

            dp[i] = num;

            if(i==size) {
                size++;
            }

        }


        return size;
    }
}
