package companies.facebook;

import java.util.Random;

public class RandomPickIndex {
    private int[] nums;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int result = 0;
        int cnt = 0;
        Random random = new Random();
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=target) {
                continue;
            }
            if(random.nextInt(++cnt)==0) {
                result = i;
            }
        }
        return result;
    }
}
