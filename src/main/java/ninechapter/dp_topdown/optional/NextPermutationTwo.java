package ninechapter.dp_topdown.optional;

import java.util.Arrays;

public class NextPermutationTwo {

    // Exactly same as next permutation one
    public int[] nextPermutation(int[] nums) {
        if(nums==null || nums.length<2) {
            return nums;
        }

        int n = nums.length;

        int index = -1;

        for(int i=n-2; i>=0; i--) {
            if(nums[i]<nums[i+1]) {
                index = i;
                break;
            }
        }

        if(index==-1) {
            Arrays.sort(nums);
            return nums;
        }

        int postion = findIndexThatIsSmallest(nums, index);
        swap(nums, index, postion);

        Arrays.sort(nums, index+1, n);
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }


    private int findIndexThatIsSmallest(int[] nums, int index) {
        int ans = index+1;
        for(int i=index+2; i<nums.length; i++) {
            if(nums[i]>nums[index] && nums[i]<nums[ans]) {
                ans = i;
            }
        }

        return ans;
    }
}
