package binarysearch;

public class FindDuplicateNumber {
    // BinarySearch based on result, this is the most difficult form of binary search
    public int findDuplicate(int[] nums) {
        int start = 1;
        int n = nums.length;
        int end = n-1;

        while(start<end) {

            int mid = (start+end)/2;

            if(findBiggerNumbers(nums, mid)>=n-mid) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    private int findBiggerNumbers(int[] nums, int k) {

        int cnt = 0;
        for(int num: nums) {

            if(num>k) {
                cnt++;
            }

        }

        return cnt;
    }
}
