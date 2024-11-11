package array;


import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }

        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // This solution is basically using optimal space
    // A hashmap solution would be trivial
    public int majorityElementWithOptimalSpace(int[] nums) {
        int res = 0;
        int majority = 0;

        for(int n: nums) {
            if(majority == 0) {
                res = n;
            }

            if(n==res) {
                majority+=1;
            } else {
                majority-=1;
            }
        }

        return res;
    }
}
