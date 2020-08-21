package ninechapter.binarysearch.optional;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) {
            return new int[]{-1, -1};
        }

        int start = findFirstIndexThatisBiggerOrEqualThanTarget(nums, target);
        if(start==nums.length || nums[start]>target) {
            return new int[]{-1, -1};
        }

        int end = findFirstIndexThatisBiggerOrEqualThanTarget(nums, target+1)-1;

        return new int[]{start, end};
    }

    private int findFirstIndexThatisBiggerOrEqualThanTarget(int[] nums, int target) {
        int left = 0;
        // Set right as nums.length, this is the key to this problem
        // because (left+right)/2 will lean towards to left, therefore
        // you will find meet outofindex exception.
        int right = nums.length;

        while(left<right) {
            int mid = (left+right)/2;
            if(nums[mid]>=target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;
    }
}
