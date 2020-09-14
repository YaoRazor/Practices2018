package array;


public class ProductOfArrayExceptSelf {

    // This is an optimized version that reuse the output array as buffer
    // TC: O(N)
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;

        for(int i=1; i<nums.length; i++) {
            ans[i] = ans[i-1]*nums[i-1];
        }

        int right = 1;

        for(int i=nums.length-1; i>=0; i--) {
            ans[i] = right*ans[i];
            right*=nums[i];
        }

        return ans;
    }
}
