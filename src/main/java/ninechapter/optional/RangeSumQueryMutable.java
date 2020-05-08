package ninechapter.optional;

import java.util.HashMap;
import java.util.Map;

public class RangeSumQueryMutable {

    Map<Integer, Integer> map;
    int[] preSum;
    int n;

    public RangeSumQueryMutable(int[] nums) {
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

    public void update(int i, int val) {
        int pre = map.get(i);
        map.put(i, val);

        for(int j=i; j<n; j++) {
            preSum[j] += (val-pre);
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
