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
                // 这里有一个小技巧，这样写的话，就可以使得start = mid+1了
                if(target>=nums[mid+1] && target<=nums[end]) {
                    start = mid+1;
                }  else {
                    end = mid;
                }
            }
        }

        return nums[start]==target? start: -1;
    }

}
