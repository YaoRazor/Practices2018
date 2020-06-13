package ninechapter.optional;

import java.util.*;

// TC: O(N), SC: O(N)
public class SubArraySum {
    public List<Integer> subarraySum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;

        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];

            if(map.containsKey(sum)) {
                ans.add(map.get(sum)+1);
                ans.add(i);
                break;
            }

            map.put(sum, i);
        }

        return ans;
    }
}
