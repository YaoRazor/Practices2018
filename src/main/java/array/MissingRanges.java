package array;


import java.util.ArrayList;
import java.util.List;

// Three edge cases that need to be handled
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();

        // long is used to handle the overflow usecase, most of the time, this is a overkill
        long lastSeen = (long)lower-1;
        long expected = (long)lower;

        for(int tmp: nums) {
            long num = (long) tmp;

            // expected<=num is used to handle the equal case in the array
            if(num!=expected && expected<=num) {
                ans.add(getString(lastSeen+1, num-1));
            }

            lastSeen = num;
            expected = num+1;
        }

        // Need to handle the last element
        if(lastSeen!=upper) {
            ans.add(getString(lastSeen+1, upper));
        }

        return ans;
    }

    private String getString(long start, long end) {
        if(start==end) {
            return String.valueOf(start);
        } else {
            return start + "->" + end;
        }
    }
}
