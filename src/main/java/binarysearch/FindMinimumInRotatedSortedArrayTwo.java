package binarysearch;

public class FindMinimumInRotatedSortedArrayTwo {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0) {
            return Integer.MIN_VALUE;
        }

        int start = 0;
        int end = nums.length-1;

        while(start<end) {

            int mid = (start+end)/2;

            if(nums[mid]>nums[end]) {
                start = mid+1;
            } else if(nums[mid]<nums[end]){
                end = mid;
            } else {
                end--;
            }

        }

        return nums[start];
    }
}
