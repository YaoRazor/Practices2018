package array;


import java.util.*;

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

    public int[] intersectUsingSort(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }

        int index = 0;
        int[] ans = new int[res.size()];

        for (int num : res) {
            ans[index++] = num;
        }

        return ans;
    }


}
