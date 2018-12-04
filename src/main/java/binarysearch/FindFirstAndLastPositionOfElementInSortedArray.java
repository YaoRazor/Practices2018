package binarysearch;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {

        if(nums==null || nums.length==0) {
            return new int[]{-1, -1};
        }

        int leftMost = -1;
        int rightMost = -1;

        // find leftMost
        int left = 0;
        int right = nums.length-1;

        while(left<right) {
            int mid = (left+right)/2;

            if(target==nums[mid] && (mid==0 || nums[mid-1]<target)) {
                leftMost = mid;
                break;
            } else if(target>nums[mid]) { //这里是>
                left = mid+1;
            } else {
                right = mid;
            }

        }

        if(nums[left]==target) {
            leftMost = left;
        }

        left = 0;
        right = nums.length-1;

        while(left<right) {
            int mid = (left+right)/2;

            if(target==nums[mid] && (mid==nums.length-1 || nums[mid+1]>target)) {
                rightMost = mid;
                break;
            } else if(target>=nums[mid]) { //注意这里是>=
                left = mid+1;
            } else {
                right = mid;
            }

        }

        if(nums[right]==target) {
            rightMost = right;
        }

        return new int[]{leftMost, rightMost};

    }
}
