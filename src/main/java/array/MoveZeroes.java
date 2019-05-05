package array;

public class MoveZeroes {
    public void moveZeroesKeepingRelativeOrder(int[] nums) {
        if(nums==null || nums.length==0) {
            return;
        }

        int i=-1; // The i here keeps an invariant which track the index to which it is already sorted

        for(int j=0; j<nums.length; j++) {

            if(nums[j]!=0) {
                swap(nums, ++i, j);
            }

        }
    }


    public void moveZeroesNotKeepingRelativeOrder(int[] nums) {

        if(nums==null || nums.length==0) {
            return;
        }

        int j = nums.length-1; // The j here keeps an invariant which tracks the index to which are zeroes

        for(int i=0; i<j; i++) {

            if(nums[i]==0) {
                swap(nums, i, j);
                j--;
                i--;
            }

        }
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
