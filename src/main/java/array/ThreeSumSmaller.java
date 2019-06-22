package array;

import java.util.Arrays;

public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        int sum = 0;
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {
            int start = i+1;
            int end = nums.length-1;

            while(start<end) {
                int tmp = nums[start] + nums[end]+nums[i];

                if(tmp< target) {
                    sum+=(end-start);
                    start++;
                } else {
                    end--;
                }
            }
        }

        return sum;
    }
}
