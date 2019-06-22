package array;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if(nums==null || nums.length==0) {
            return 1;
        }

        int n = nums.length;
        for(int i=0; i<n; i++) {
            while(nums[i]>0 && nums[i]<=n && nums[nums[i]-1]!=nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }

        for(int i=0; i<n; i++) {
            if(nums[i]!=i+1) {
                return i+1;
            }
        }

        return nums.length+1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    // It is fairly easy to implement a solution with O(N) memory,
    // but in order to implement a solution with constant memory,
    // you have to use the above solution, which is hard to think of
    // on spot
    public int firstMissingPositiveWithNLengthMemory(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int ans = 1;

        for(int num: nums) {
            seen.add(num);
            while(seen.contains(ans)) {
                ans++;
            }
        }

        return ans;
    }
}
