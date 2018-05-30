package miscellaneous;

/**
 * Created by yawang on 4/19/18.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        if(nums == null || nums.length == 0) {
            return result;
        }

        for(int i=0; i<nums.length; i++) {
            result^=nums[i];
        }

        return result;
    }
}
