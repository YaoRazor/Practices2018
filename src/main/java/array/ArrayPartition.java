package array;


import java.util.Arrays;

public class ArrayPartition {
    public int arrayPairSum(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }

        Arrays.sort(nums);
        int sum = 0;

        for(int i=0; i<nums.length-1; i=i+2) {

            sum+= Math.min(nums[i], nums[i+1]);

        }

        return sum;
    }
}
