package binarysearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;

        while(i<j) {
            int mid = (i+j)/2;
            if(nums[mid]<target) {
                i = mid+1;
            } else {
                j = mid;
            }
        }

        return nums[i] == target? i: -1;
    }
}
