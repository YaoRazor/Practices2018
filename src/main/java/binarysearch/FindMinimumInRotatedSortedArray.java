package binarysearch;

public class FindMinimumInRotatedSortedArray {

    // Nine chapter ooxx approach, the goal is to find the first element that is smaller than the rightmost element
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length-1;

        while(start<end) {

            int mid = (start+end)/2;

            if(nums[mid]<nums[end]) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return nums[start];

    }
}
