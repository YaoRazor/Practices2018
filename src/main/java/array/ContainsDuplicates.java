package array;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

    // Sorting version
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length == 0) {
            return false;
        }

        Arrays.sort(nums);

        for(int i=0; i<nums.length-1; i++) {

            if(nums[i] == nums[i+1]){
                    return true;
            }
        }

        return false;
    }

    // HashMap version
    public boolean containsDuplicateUsingHashMap(int[] nums) {
        if(nums==null || nums.length == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();

        for(int i: nums) {
            if(set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }
        }

        return false;
    }


}
