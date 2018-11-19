package binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arrList, int k, int x) {
        List<Integer> arr = new ArrayList<>();
        for(int tmp: arrList) {
            arr.add(tmp);
        }
        int index = Collections.binarySearch(arr, x);
        if(index < 0) index = -(index + 1); //如果Collections.binarySearch找到了这个element，那么返回的是insertion index, 否则返回的是-insertion_index-1, 这里就是用来handle这个的
        int i = index-1 , j = index;
        while(k > 0){
            if(i<0 || (j<arr.size() && Math.abs(arr.get(i) - x) > Math.abs(arr.get(j) - x) )) {
                j++;
            } else {
                i--;
            }

            k--;
        }
        return arr.subList(i+1, j);

    }
}
