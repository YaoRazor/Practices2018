package companies.facebook;

public class SingleElementInSortedArray {

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left<right) {
            int mid = (left+right)/2;
            if(mid%2==0) {
                if(nums[mid]==nums[mid+1]) {
                    left+=2;
                } else {
                    right = mid;
                }
            } else {
                if(nums[mid]==nums[mid-1]) {
                    left+=1;
                } else {
                    right = mid;
                }
            }
        }

        return nums[left];
    }
}
