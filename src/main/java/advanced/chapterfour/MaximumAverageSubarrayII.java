package advanced.chapterfour;

public class MaximumAverageSubarrayII {

    // BinarySearch on result
    // TC: O(nlog(range)), as this is double, so actually it is not log(range) anymore
    // it also depends on the the accuracy specified
    public double maxAverage(int[] nums, int k) {
        if(nums==null || nums.length<k) {
            return 0d;
        }

        double min = (double)nums[0];
        double max = (double)nums[0];
        for(int num: nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        while(max-min>1e-5) {
            double mid = (max+min)/2;
            if(canFind(nums, k, mid)) {
                min = mid;
            } else {
                max = mid;
            }
        }

        return min;
    }

    private boolean canFind(int[] nums, int k, double avg) {
        double sum = 0d;
        double leftSum = 0d;
        double minLeftSum = 0d;

        for(int i=0; i<k; i++) {
            sum+=nums[i]-avg;
        }

        for(int i=k; i<nums.length; i++) {
            if(sum-minLeftSum>=0) {
                return true;
            }

            sum+=nums[i]-avg;
            leftSum+=nums[i-k]-avg;
            minLeftSum = Math.min(leftSum, minLeftSum);
        }

        if(sum-minLeftSum>=0) {
            return true;
        }
        return false;
    }

}
