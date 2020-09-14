package companies.facebook;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            // trick one
            if(k!=0) {
                sum = sum%k;
            }

            if(map.containsKey(sum)) {
                // trick two
                if(map.get(sum)<i-1) {
                    return true;
                }
            } else {
                // trick three
                map.put(sum, i);
            }
        }

        return false;
    }
}
