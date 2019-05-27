package twopointers;

public class SortColors {
    // This method actually is a little bit tricky, the
    // two pass counting sort solution is more intuitive
    public void sortColors(int[] nums) {
        if(nums==null) {
            return;
        }

        int j = -1;
        int k = nums.length;
        int i = 0;

        while(i<k) {
            if(nums[i]==0) {
                swap(nums, i, j+1);
                j++; //i-j is always > 1, otherwise there could be index out boundery issue
            } else if(nums[i]==2) {
                swap(nums, i, k-1);
                k--;
                i--;
            }
            i++;
        }

        return;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
