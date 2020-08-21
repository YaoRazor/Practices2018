package binarysearch;

import java.util.Random;

public class RandomPickWithWeight {
    int[] nums;
    Random random = new Random();

    public RandomPickWithWeight(int[] w) {
        nums = new int[w.length];
        int cnt = w[0];
        nums[0] = cnt;
        for(int i=1; i<w.length; i++) {
            cnt+=w[i];
            nums[i] = cnt;
        }
    }

    public int pickIndex() {
        int index = random.nextInt(nums[nums.length-1]);

        int left = 0;
        int right = nums.length-1;

        while(left<right) {
            int mid = (left+right)/2;
            if(index<nums[mid]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;
    }
}
