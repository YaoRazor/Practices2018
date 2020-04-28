package ninechapter.twopointers;;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numbers==null || numbers.length < 3) {
            return ans;
        }

        Arrays.sort(numbers);

        for(int i=0; i<numbers.length; i++) {
            int cur = numbers[i];
            int start = i+1;
            int end = numbers.length-1;

            while(start<end) {
                if(numbers[start]+numbers[end]==0-cur) {
                    ans.add(Arrays.asList(cur, numbers[start], numbers[end]));

                    while(start+1<numbers.length && numbers[start+1]==numbers[start]) {
                        start++;
                    }

                    while(end-1>=0 && numbers[end-1]==numbers[end]) {
                        end--;
                    }

                    start++;
                    end--;

                } else if(numbers[start]+numbers[end]>0-cur) {
                    end--;
                } else {
                    start++;
                }
            }

            while(i+1<numbers.length && numbers[i+1]==numbers[i]) {
                i++;
            }
        }

        return ans;
    }

}
