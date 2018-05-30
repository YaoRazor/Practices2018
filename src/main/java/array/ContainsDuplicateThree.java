package array;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicateThree {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if(t<0) {
            return false; // Might be it is better to throw exception
        }

        Map<Long, Long> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            long index = getID((long)nums[i], (long)t);

            if(map.containsKey(index)) {
                return true;
            } else if(map.containsKey(index-1) && Math.abs(nums[i]-map.get(index-1))<=t){
                return true;

            } else if(map.containsKey(index+1) && Math.abs(nums[i]-map.get(index+1))<=t) {
                return true;
            }


            map.put(index, (long)nums[i]); // put first and then remove
            if(map.size()>k) {
                map.remove(getID(nums[i-k],(long)t));
            }

        }

        return false;
    }


    // you need to use long instead of int here
    private long getID(long n, long t) {

        if(n>=0) {
            return n/(t+1); // The reason we use (t+1) here is because t could be zero
        } else {
            return (n+1)/(t+1)-1;
        }

    }


    public boolean containsNearbyAlmostDuplicateTwo(int[] nums, int k, int t) {
        if(t<0) {
            return false; // Might be it is better to throw exception
        }

        TreeSet<Integer> set = new TreeSet<>();


        for(int i=0; i<nums.length; i++) {

            Integer large = set.ceiling(nums[i]);

            if(large!=null && nums[i]+t<=large) {
                return true;
            }

            Integer small = set.floor(nums[i]);

            if(small!=null && small+t<nums[i]) {
                return true;
            }

            set.add(nums[i]);

            if(set.size()>k) {
                set.remove(nums[i-k]);
            }
        }

        return false;

    }
}
