package twopointers;

public class SortColors {
    public void sortColors(int[] nums) {

        if(nums==null || nums.length==0) {
            return;
        }

        int i = -1;
        int j = nums.length;
        int k = 0;

        while(k<j) {

            if(nums[k]==1) {
                k++;
            } else if(nums[k]==0) {

                swap(nums, k, i+1);
                k++;
                i++;

            } else {
                swap(nums, k, j-1);
                j--;
            }

        }

    }

    private void swap(int[] nums, int i, int j) {

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }
}
