package binarysearch;

import java.util.LinkedList;
import java.util.List;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length-1;
        int index = 0;

        // Find the first element that is equal or bigger then x, if
        // all elements are smaller than x, then index will be equal to arr.length
        while(start<end) {
            int mid = (start+end)/2;
            if(arr[mid]<x) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        index = start;

        return findClosestElements(arr, k, x, index);
    }


    private List<Integer> findClosestElements(int[] arr, int k, int x, int index) {
        int i = index-1;
        int j = index;

        LinkedList<Integer> ans = new LinkedList<>();

        while(k>0) {

            int smaller = Integer.MAX_VALUE;
            int bigger = Integer.MAX_VALUE;

            if(i>=0) {
                smaller = Math.min(Math.abs(x-arr[i]), smaller);
            }

            if(j<arr.length) {
                bigger = Math.min(bigger, Math.abs(arr[j]-x));
            }

            if(smaller<=bigger) {
                ans.addFirst(arr[i--]);  //Add first here to maintain order
            } else {
                ans.add(arr[j++]);
            }

            k--;
        }

        return ans;
    }
}
