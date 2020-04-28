package ninechapter.twopointers;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromArray {

    // O(nlogn) time, O(1) space
    public int removeDuplicatesUsingSort(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }

        Arrays.sort(nums);
        int pre = 0;

        for(int i=1; i<nums.length; i++) {
            if(nums[i]!=nums[pre]) {
                nums[++pre] = nums[i];
            }
        }

        return pre+1;
    }

    // O(n) time, O(n) space
    public int removeDuplicatesUsingSet(int[] nums) {
        // Write your code here
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; ++i){
            set.add(nums[i]);
        }
        int result = 0;
        for (Integer i : set){
            nums[result++] = i;
        }
        return result;
    }
}
