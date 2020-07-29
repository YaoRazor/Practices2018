package ninechapter.twopointers.related;

public class PartitionArrayTwo {

    public void partition2(int[] nums, int low, int high) {
        if(nums==null || nums.length<2) {
            return;
        }

        int left = -1;
        int right = nums.length;

        for(int i=0; i<right; i++) {
            if(nums[i]<low) {
                swap(nums, i, ++left);
            } else if(nums[i]>high) {
                swap(nums, i, --right);
                i--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
