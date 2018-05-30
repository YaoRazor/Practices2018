package array;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysTwo {
    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1 == null || nums1.length == 0
                || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();

        for(int i: nums1) {

            if(map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }

        }

        for(int i: nums2) {
            if(map.containsKey(i) && map.get(i)>0) {
                list.add(i);
                map.put(i, map.get(i)-1);
            }
        }

        int[] ret = new int[list.size()];

        return list.stream().mapToInt(i->i).toArray();

    }
}
