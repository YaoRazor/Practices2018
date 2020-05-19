package ninechapter.hash_and_heap.optional;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    // This method is letting you to do it only from the beginning of the streak
    // so that we can keep the algorithm time complexity as O(n)
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

    public int longestConsecutiveMethodTwo(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }

        int ans = 1;

        // We have to loop through nums, using set to loop will cause some exception
        for(int cur: nums) {
            int tmp = 1;
            int pre = cur;
            set.remove(cur);
            while(set.contains(cur-1)) {
                tmp++;
                cur--;
                set.remove(cur);
            }

            cur = pre;

            while(set.contains(cur+1)) {
                tmp++;
                cur++;
                set.remove(cur);
            }

            ans = Math.max(ans, tmp);
        }

        return ans;
    }
}
