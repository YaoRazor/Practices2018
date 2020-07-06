package ninechapter.optional.related;

public class MaximumSubarrayDifference {

    // TC: O(n) SC: O(N)
    public int maxDiffSubArrays(int[] nums) {
        if(nums==null || nums.length<2) {
            return 0;
        }

        int n = nums.length;

        int[] leftMax = new int[n];
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        int[] rightMin = new int[n];

        int maximumEndingHere = nums[0];
        leftMax[0] = nums[0];

        for(int i=1; i<nums.length; i++) {
            maximumEndingHere = Math.max(maximumEndingHere+nums[i], nums[i]);
            leftMax[i] = Math.max(maximumEndingHere, leftMax[i-1]);
        }

        rightMax[n-1] = nums[n-1];
        maximumEndingHere = nums[n-1];

        for(int i=n-2; i>=0; i--) {
            maximumEndingHere = Math.max(maximumEndingHere+nums[i], nums[i]);
            rightMax[i] = Math.max(maximumEndingHere, rightMax[i+1]);
        }


        int minimumEndingHere = nums[0];
        leftMin[0] = nums[0];

        for(int i=1; i<nums.length; i++) {
            minimumEndingHere = Math.min(minimumEndingHere+nums[i], nums[i]);
            leftMin[i] = Math.min(minimumEndingHere, leftMin[i-1]);
        }

        minimumEndingHere = nums[n-1];
        rightMin[n-1] = nums[n-1];

        for(int i=n-2; i>=0; i--) {
            minimumEndingHere = Math.min(minimumEndingHere+nums[i], nums[i]);
            rightMin[i] = Math.min(minimumEndingHere, rightMin[i+1]);
        }

        int diff = 0;

        for(int i = 0; i < n - 1; i++){
            diff = Math.max(diff, Math.abs(leftMax[i] - rightMin[i + 1]));
            diff = Math.max(diff, Math.abs(leftMin[i] - rightMax[i + 1]));
        }

        return diff;
    }
}
