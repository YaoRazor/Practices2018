package ninechapter.twopointers;

public class PartitonArray {
    public int partitionArray(int[] nums, int k) {
        int cur = -1;

        for(int i=0; i<nums.length; i++) {
            if(nums[i]<k) {
                swap(nums, ++cur, i);
            }
        }

        return cur+1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
