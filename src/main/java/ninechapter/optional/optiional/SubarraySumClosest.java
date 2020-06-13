package ninechapter.optional.optiional;

import java.util.Arrays;
import java.util.Comparator;

public class SubarraySumClosest {

    class Point{
        int index, sum;
        Point(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "index is "+index+" sum is "+sum+"\n";
        }
    }

    // TC: O(nlogn). SC: O(n)
    public int[] subarraySumClosest(int[] nums) {
        if(nums==null || nums.length==0) {
            return new int[]{};
        }

        int n = nums.length;

        Point[] preSum = new Point[n+1];
        int sum = 0;
        preSum[0] = new Point(0, 0);
        for (int i=1; i<=n; i++){
            sum+=nums[i-1];
            preSum[i] = new Point(i, sum);
        }

        int[] ans = new int[2];

        Arrays.sort(preSum, (p1, p2)->p1.sum-p2.sum);
        // System.out.println(Arrays.toString(preSum));
        int difference = Integer.MAX_VALUE;

        for(int i=1; i<=n; i++) {
            if(preSum[i].sum-preSum[i-1].sum<difference) {
                ans[0] = Math.min(preSum[i].index, preSum[i-1].index);
                ans[1] = Math.max(preSum[i].index, preSum[i-1].index)-1;
                difference = preSum[i].sum-preSum[i-1].sum;
            }
        }

        return ans;
    }
}
