package ninechapter.twopointers;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums==null) {
            return;
        }
        int cur = -1;

        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=0) {
                swap(nums, ++cur, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
