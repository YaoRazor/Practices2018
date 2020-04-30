package ninechapter.binarysearch;

public class MaximumNumberInMountainSequence {
    public int mountainSequence(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while(start+1<end) {
            int mid = start + (end-start)/2;

            if(nums[mid]>nums[mid+1]) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return Math.max(nums[start], nums[end]);
    }
}
