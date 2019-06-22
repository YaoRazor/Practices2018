package array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    // This method is letting you to do it only from the beginning of the streak
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }

        int ans = 0;

        for(int num: nums) {
            if(set.contains(num-1)) {
                continue;
            }

            int upper = num+1;
            while(set.contains(upper)) {
                upper++;
            }
            ans = Math.max(ans, upper-num);
        }

        return ans;
    }
}
