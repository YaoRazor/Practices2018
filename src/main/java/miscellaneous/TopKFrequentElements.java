package miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();

        if(nums==null || nums.length==0) {
            return ans;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer>[] bucket = new List[nums.length+1];

        for(Integer cur: map.keySet()) {
            int frequency = map.get(cur);

            if(bucket[frequency]==null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(cur);
        }

        for(int i=bucket.length-1; i>=0; i--) {

            if(bucket[i]!=null) {
                for(Integer cur: bucket[i]) {

                    if(k>0) {
                        ans.add(cur);
                        k--;
                    } else {
                        return ans;
                    }
                }

            }

        }

        return ans;
    }
}
