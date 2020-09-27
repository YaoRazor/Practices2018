package binarysearch;

import java.util.LinkedList;
import java.util.List;

// TC: O(logN+k)
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        // LinkedList的使用是点睛之笔
        LinkedList<Integer> ans = new LinkedList<>();

        int left = findLastElementThatIsSmallerOrEqualToTarget(nums, x);
        int right = left+1;

        while(k>0) {
            if(left>=0 && (right==nums.length || Math.abs(nums[left]-x)<=Math.abs(nums[right]-x))) {
                //因为有了LinkedList，所以就可以使用addFirst这个方法
                ans.addFirst(nums[left--]);
            } else {
                ans.add(nums[right++]);
            }

            k--;
        }

        return ans;
    }

    private int findLastElementThatIsSmallerOrEqualToTarget(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start+1<end) {
            int mid = (start+end)/2;
            if(nums[mid]>target) {
                end = mid-1;
            } else {
                start = mid;
            }
        }

        return nums[end]<=target? end: start;
    }
}
