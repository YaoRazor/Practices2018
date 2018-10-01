package airbnb;

import java.util.Arrays;

public class ThreeSumCloest {


    public int threeSumClosest(int[] nums, int target) {


        Arrays.sort(nums);
        int difference = Integer.MAX_VALUE;
        int ans = 0;

        for(int i=0; i< nums.length-2; i++) {

            int tmp = nums[i];
            int l = i+1;
            int r = nums.length-1;


            while(l<r) {

                int cur = nums[l]+nums[r]+tmp;

                if(Math.abs(cur-target) < difference) {

                    ans = cur;
                    difference = Math.abs(cur-target);

                    System.out.printf(i+","+l+","+r+"\n");

                }

                if(cur > target) {
                    r--;
                } else {
                    l++;
                }

            }

            while(i<nums.length-1 && nums[i+1]==nums[i]) {
                i++;
            }

        }

        return ans;

    }
}
