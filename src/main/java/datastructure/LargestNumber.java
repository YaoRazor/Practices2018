package datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber {

    public String largestNumber(int[] nums) {

        StringBuilder sb = new StringBuilder();

        if(nums==null || nums.length==0) {
            return sb.toString();
        }


        List<String> numsList = new ArrayList<>();

        for(int num: nums) {
            numsList.add(String.valueOf(num));
        }


        Collections.sort(numsList, (o1, o2) -> {

            String tmp1 = o1+o2;
            String tmp2 = o2+o1;

            return tmp2.compareTo(tmp1);
        });


        for(String s: numsList) {
            sb.append(s);
        }

        if(sb.charAt(0)=='0') {
            return "0";
        }


        return sb.toString();

    }
}
