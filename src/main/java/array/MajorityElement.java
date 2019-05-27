package array;


import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }

        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
