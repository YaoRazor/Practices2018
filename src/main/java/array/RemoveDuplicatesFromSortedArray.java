package array;


public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {

        if(nums==null || nums.length == 0) {
            return 0;
        }

        int j = 0; // invariant of sorted index
        int cur = nums[0];

        for(int i=1; i< nums.length; i++) {
            if(nums[i]!=cur) {
                nums[++j] = nums[i];
                cur = nums[i];
            }
        }

        return j+1;

    }
}
