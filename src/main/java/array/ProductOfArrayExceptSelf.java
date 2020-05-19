package array;


public class ProductOfArrayExceptSelf {

    // This is an optimized version that reuse the output array as buffer
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

    // This is an intuitive solution
    public int[] productExceptSelfUsingNonConstantSpace(int[] nums) {
        int[] pre = new int[nums.length+1];
        pre[0] = 1;
        int[] after = new int[nums.length+1];
        after[nums.length] = 1;

        for(int i=1; i<=nums.length; i++) {
            pre[i] = pre[i-1]*nums[i-1];
        }

        for(int i=nums.length-1; i>=0; i--) {
            after[i] = after[i+1]*nums[i];
        }

        int[] ans = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            ans[i] = pre[i] * after[i+1];
        }


        return ans;
    }
}
