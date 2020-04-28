package ninechapter.twopointers;

import java.util.HashMap;
import java.util.Map;

// The key point actually is to know whether the array is sorted or not
public class TwoSum {
    public int[] twoSumSorted(int[] nums, int target) {

        int i=0, j=nums.length -1;

        while(i<j) {

            if(nums[i]+nums[j]==target) {
                return new int[] {i+1, j+1};
            } else if(nums[i]+nums[j]>target) {
                j--;
            } else {
                i++;
            }
        }

        return null;
    }


    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {

            if(map.containsKey(target-nums[i])) {
                return new int[] {map.get(target-nums[i]), i};
            } else {
                map.put(nums[i], i);
            }

        }

        return null;
    }

}
