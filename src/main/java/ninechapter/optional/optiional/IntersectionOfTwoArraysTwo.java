package ninechapter.optional.optiional;

import java.util.*;

public class IntersectionOfTwoArraysTwo {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0) {
            return new int[]{};
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        List<Integer> ans = new ArrayList<>();

        while(i<nums1.length && j<nums2.length) {

            if(nums1[i]==nums2[j]) {
                ans.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i]>nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] res = new int[ans.size()];

        for(i=0; i<res.length; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}
