package advanced.chapterseven;

import java.util.Arrays;

public class MaximumGap {

    // TC: O(N). SC: O(N)
    public int maximumGap(int[] nums) {
        if(nums==null || nums.length<2)
            return 0;

        int min=nums[0];
        int max=nums[0];

        for(int n: nums){
            min=Math.min(min, n);
            max=Math.max(max, n);
        }
        if(min==max) {
            return 0;
        }

        int n=nums.length;

        // Technically gap should be Math.floor, but in case gap becomes zero, we add 1 here,
        // it does not impact the final result
        int gap = (int)Math.ceil((double)(max-min)/(n-1));
        int len = (max-min)/gap+1;

        int bucketMin[] = new int[len];
        int bucketMax[] = new int[len];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for(int num: nums){
            int i=(num-min)/gap;
            bucketMin[i] = Math.min(bucketMin[i], num);
            bucketMax[i] = Math.max(bucketMax[i], num);
        }

        int ans = 0;

        for(int i=0;i<bucketMin.length;++i){
            if(bucketMin[i]!=Integer.MAX_VALUE){
                ans = Math.max(ans, bucketMin[i]-min);
                min = bucketMax[i];
            }
        }

        ans = Math.max(ans, max-min);

        return ans;
    }

}
