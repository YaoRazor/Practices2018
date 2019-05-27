package bst;


public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0) {
            return 0;
        }

        int start = 0;
        int end = nums.length-1;

        while(start<=end) {
            int mid = (start+end)/2;
            if(nums[mid]==target) {
                return mid;
            } else if(nums[mid]>target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        // In the end, start will be bigger than end by 1, therefore, we return start here
        return start;
    }
}
