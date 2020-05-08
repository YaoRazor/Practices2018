package ninechapter.optional.optiional;

import java.util.HashMap;
import java.util.Map;

public class RangeSumQueryImutable {
    Map<Integer, Integer> map;
    int[] preSum;
    int n;

    public RangeSumQueryImutable(int[] nums) {
        map = new HashMap<>();
        n = nums.length;
        preSum = new int[n];

        for(int i=0; i<n; i++) {
            map.put(i, nums[i]);
            preSum[i] = nums[i];

            if(i>0) {
                preSum[i]+=preSum[i-1];
            }
        }
    }

    public int sumRange(int i, int j) {
        if(i>0) {
            return preSum[j] - preSum[i-1];
        } else {
            return preSum[j];
        }
    }
}
