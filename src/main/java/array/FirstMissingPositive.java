package array;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if(nums==null || nums.length==0) {
            return 1;
        }

        for(int i=0; i<nums.length; i++) {

            if(nums[i]>0 && nums[i]<=nums.length && nums[nums[i]-1]!=nums[i]) {
                swap(nums, nums[i]-1, i);
                i--;
            }

        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=i+1) {
                return i+1;
            }
        }

        return nums.length+1;
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;

    }
}
