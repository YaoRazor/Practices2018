package advanced.chapterseven;

import java.util.ArrayList;
import java.util.List;

// TC: O(N), SC: O(1)
public class ContinuousSubarraySum {

    public List<Integer> continuousSubarraySum(int[] A) {
        List<Integer> ans = new ArrayList<>();
        if(A==null || A.length==0) {
            return ans;
        }
        ans.add(0);
        ans.add(1);
        int minSum = 0;
        int pre = -1;
        int curMax = Integer.MIN_VALUE;
        int curSum = 0;

        for(int i=0; i<A.length; i++) {
            curSum+=A[i];
            if(curSum-minSum>curMax) {
                ans.set(0, pre+1);
                ans.set(1, i);
                curMax = curSum-minSum;
            }

            if(curSum<minSum) {
                minSum = curSum;
                pre = i;
            }
        }

        return ans;
    }
}
