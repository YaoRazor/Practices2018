package array;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {

        if(nums==null || nums.length==0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int num: nums) {
            set.add(num);
        }

        int ans = 1;

        for(int num: nums) {
            if(!set.contains(num-1)) {
                Integer cur = num;
                while (set.contains(cur+1)) {
                    cur+=1;

                    ans = Math.max(ans, cur-num+1);

                }
            }
        }

        return ans;
    }
}
