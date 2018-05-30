package array;

/**
 * Created by yawang on 4/29/18.
 */
public class RemoveElement {
   // Given nums = [0,1,2,2,3,0,4,2], val = 2,

   // Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4
    public int removeElement(int[] nums, int val) {

        if(nums==null) {
            return 0;
        }

        int k = -1; //invariant to store where current element is sorted


        for(int i=0; i<nums.length; i++) {

            if(nums[i]==val) {
                continue;
            } else {
                int tmp = nums[k+1];
                nums[++k] = nums[i];
                nums[i] = tmp;
            }

        }

        return k+1;
    }
}
