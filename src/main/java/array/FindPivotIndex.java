package array;


public class FindPivotIndex {

    public int pivotIndex(int[] nums) {

        if(nums.length==0) {
            return -1;
        }

        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
        }

        int left = 0;

        for(int i=0; i<nums.length-1; i++) {
            left+=nums[i];
            if(sum-nums[i+1] == 2*left) {
                return i+1;
            }
        }

        return -1;
    }
}
