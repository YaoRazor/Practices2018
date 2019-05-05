package array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        if(nums==null || nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {

            int target = 0-nums[i];
            int l = i+1;
            int r = nums.length-1;

            while(l<r) {

                if(nums[l]+nums[r]==target) {

                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;

                    while(l<r && nums[l]==nums[l-1]) {
                        l++;
                    }

                    while(l<r && nums[r]==nums[r+1]) {
                        r--;
                    }

                } else if(nums[l]+nums[r]<target) {
                    l++;
                } else {
                    r--;
                }

            }

            while(i<nums.length-1 && nums[i+1]==nums[i]) {
                i++;
            }

        }

        return ans;

    }

}
