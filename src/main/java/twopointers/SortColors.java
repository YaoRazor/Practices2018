package twopointers;

import utilities.ArrayUtilities;

public class SortColors {
    // One pass is slightly tricky, the
    // two pass counting sort solution is more intuitive
    public void sortColors(int[] nums) {
        int left = -1;
        int right = nums.length;

        int i = 0;

        while(i<right) {
            int cur = nums[i];
            // i needs to move in both cases
            // that nums[i]==0 or 1, but should
            // not move when nums[i]==2
            if(cur==0) {
                swap(nums, left+1, i);
                left++;
                i++;
            } else if(cur==2) {
                swap(nums, right-1, i);
                right--;
            } else {
                i++;
            }
        }

        return;
    }

    private void swap(int[] nums, int i, int j) {
        ArrayUtilities.swap(nums, i, j);
    }
}
