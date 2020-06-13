package advanced.chapterfour.related;

public class MaximumAverageSubarray {

    // TC: O(N), SC: O(N)
    public double findMaxAverage(int[] nums, int k) {
        if(nums==null || nums.length<k) {
            return 0;
        }

        int n = nums.length;

        int[] sum = new int[n+1];
        sum[0] = 0;
        for(int i=1; i<=n; i++) {
            sum[i] = sum[i-1]+nums[i-1];
        }

        double ans = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i+k<=n; i++) {
            if(sum[i+k]-sum[i]>max) {
                max = sum[i+k]-sum[i];
                ans = (double)max/k;
            }
        }

        return ans;
    }
}
