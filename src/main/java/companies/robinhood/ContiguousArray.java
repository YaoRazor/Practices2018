package companies.robinhood;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        if(nums==null || nums.length<2) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int ans = 0;

        for(int i=0; i<nums.length; i++) {
            sum+=nums[i]==0? -1: 1;
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                ans = Math.max(ans, i-map.get(sum));
            }
        }

        return ans;
    }
}
