package array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    // This method is letting you to do it only from the beginning of the streak
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


    // This way you will remove the element you already counted
    public int longestConsecutiveWithSetRemove(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for(int num: nums) {
            set.add(num);
        }

        int ans = 0;

        for(int i=0; i<nums.length; i++) {

            if(set.contains(nums[i])) {
                ans = Math.max(ans, getDistance(set, nums[i]));
            }

        }


        return ans;
    }


    private int getDistance(Set<Integer> set, int num) {

        int bottem = num;
        int top = num;
        int cur = num;

        while(set.contains(cur-1)) {
            set.remove(cur-1);
            bottem = cur-1;
            cur = cur-1;
        }

        cur = num;

        while(set.contains(cur+1)) {
            set.remove(cur+1);
            top = cur+1;
            cur = cur+1;
        }

        return top-bottem+1;

    }
}
