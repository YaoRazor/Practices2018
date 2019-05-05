package array;

import java.util.Arrays;

public class ThreeSumCloest {


    public int threeSumClosest(int[] nums, int target) {


        int difference = Integer.MAX_VALUE;
        int sum = 0;

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {

            int start = i+1;
            int end = nums.length-1;

            while(start<end) {

                int tmp = nums[start] + nums[end]+nums[i];

                if(Math.abs(tmp-target)<difference) {
                    difference = Math.abs(tmp-target);
                    sum = tmp;
                }

                // This is an optimization
                if(tmp==target) {
                    return sum;
                }

                if(tmp>target) {
                    end--;
                } else {
                    start++;
                }

            }

            // This is an optimization, this is not required for this problem
            while(i<nums.length-1 && nums[i+1]==nums[i]) {
                i++;
            }


        }

        return sum;

    }
}
