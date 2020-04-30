package ninechapter.binarysearch;

public class FindMinimumInRotatedSortedArray {

    // Nine chapter ooxx approach, the goal is to find the first element that is smaller than the rightmost element
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while(start+1<end) {
            int mid = start+(end-start)/2;

            if(nums[mid]>nums[nums.length-1]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}
