package ninechapter.optional.optiional;

import java.util.Arrays;
import java.util.Comparator;

public class SubarraySumClosest {

    class Pair {
        public int index;
        public int sum;

        public Pair(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }

    public int[] subarraySumClosest(int[] nums) {
        if(nums==null || nums.length < 1) {
            return null;
        }

        if(nums.length==1) {
            return new int[]{0, 0};
        }

        int n = nums.length;

        Pair[] pairs = new Pair[n+1];
        pairs[0] = new Pair(-1, 0);
        int sum = 0;

        for(int i=0; i<n; i++) {
            sum += nums[i];
            pairs[i+1] = new Pair(i, sum);
        }

        // The key to this problem is to use sort to find which subarrays have closest sum
        Arrays.sort(pairs, Comparator.comparingInt(p -> p.sum));

        int[] ans = new int[2];
        int difference = Integer.MAX_VALUE;

        for(int i=1; i<=n; i++) {
            if(pairs[i].sum-pairs[i-1].sum<difference) {
                ans[0] = pairs[i].index;
                ans[1] = pairs[i-1].index;
                difference = pairs[i].sum-pairs[i-1].sum;
            }
        }

        Arrays.sort(ans);
        ans[0] = ans[0]+1;
        return ans;
    }
}
