package binarysearch;

public class SearchInRotatedArrayTwo {
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0) {
            return false;
        }

        int start = 0;
        int end = nums.length-1;

        while(start<end) {
            int mid = (start+end)/2;
            if(nums[mid]>nums[end]) {
                if(target>=nums[start] && target<=nums[mid]) {
                    end = mid;
                }   else {
                    start = mid+1;
                }
            } else if(nums[mid]<nums[end]){
                if(target>=nums[mid+1] && target<=nums[end]) {
                    start = mid+1;
                }  else {
                    end = mid;
                }
            } else {
                end--;
            }
        }

        return nums[start]==target;
    }
}
