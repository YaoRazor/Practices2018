package array;


import java.util.ArrayList;
import java.util.List;

// Three edge cases that need to be handled
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ret = new ArrayList<>();
        // long is used to handle overflow
        long pre = (long)lower -1;
        long cur ;

        for(int i=0; i<=nums.length; i++) {
            // upper needs to add extra one
            cur = i == nums.length ? (long)upper + 1: (long)nums[i];

            // cur!=pre handles the equal case
            if(cur!=(pre+1) && cur!=pre) {
                if(cur == (pre+2)) {
                    ret.add(String.valueOf(pre+1));
                } else {
                    String tmp = String.valueOf(pre+1)+"->"+String.valueOf(cur-1);
                    ret.add(tmp);
                }
            }

            pre = cur;
        }

        return ret;
    }
}
