package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {

            int target = 0-nums[i];
            int start = i+1;
            int end = nums.length -1;

            while(start < end) {
                if(nums[start]+nums[end] == target) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;

                    while(start<end && nums[start] == nums[start-1]) {
                       start++;
                    }

                    while(start<end && nums[end] == nums[end+1]) {
                        end--;
                    }

                } else if(nums[start]+nums[end] > target) {
                    end--;
                } else {
                    start++;
                }
            }

            while(i+1<nums.length-1 && nums[i+1] == nums[i]) {
               i++;
            }

        }

        return  result;
    }
}
