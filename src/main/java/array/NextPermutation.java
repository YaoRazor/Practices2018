package array;

public class NextPermutation {
    public void nextPermutation(int[] nums) {

        int i = nums.length-1;

        while (i>=1 && nums[i-1]>=nums[i]) {
            i--;
        }

        if(i==0) {
            reverse(nums, 0);
            return;
        }

        int k = i-1;

        int tmp = nums[i-1];

        for(; i< nums.length; i++) {

            if(nums[i]>tmp) {
                continue;
            } else {
                break;
            }
        }

        swap(nums, k, i-1);

        reverse(nums, k+1);
    }


    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

}
