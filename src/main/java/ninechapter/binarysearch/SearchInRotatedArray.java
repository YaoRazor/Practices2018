package ninechapter.binarysearch;

public class SearchInRotatedArray {

    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0) {
            return -1;
        }

        int start = 0;
        int end = nums.length-1;

        while(start<end) {
            int mid = (start+end)/2;
            if(nums[mid]>nums[end]) {
                if(target>=nums[start] && target<=nums[mid]) {
                    end = mid;
                } else {
                    start = mid+1;
                }

            } else {
                if(target>nums[mid] && target<=nums[end]) {
                    start = mid+1;
                }  else {
                    end = mid;
                }
            }
        }

        return nums[start]==target? start: -1;
    }

}
