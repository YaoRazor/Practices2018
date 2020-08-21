package binarysearch;

import java.util.LinkedList;
import java.util.List;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> ans = new LinkedList<>();

        int start = 0;
        int end = arr.length-1;

        while(start+1<end) {
            int mid = (start+end)/2;
            if(arr[mid]==x) {
                start = mid;
                break;
            } else if(arr[mid]>x) {
                end = mid-1;
            } else {
                start = mid;
            }
        }

        end = start+1;

        int cnt = 0;
        while(cnt<k) {
            if(start>=0 && (end>=arr.length || Math.abs(arr[start]-x)<=Math.abs(arr[end]-x))) {
                ans.addFirst(arr[start--]);
            } else {
                ans.add(arr[end++]);
            }

            cnt++;
        }

        return ans;
    }
}
