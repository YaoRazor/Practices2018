package array;


public class MissingNumber {
    public int missingNumber(int[] nums) {
        if(nums==null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int expected = n*(n+1)/2;
        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
        }

        return expected - sum;
    }


    public int missingNumbeXor(int[] nums) {
        if(nums==null || nums.length == 0) {
            return 0;
        }

        int ret = 0;

        for(int i=0; i<nums.length; i++) {
            ret = ret^i^nums[i];
        }

        return ret^nums.length;
    }
}
