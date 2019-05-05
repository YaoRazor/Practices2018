package array;

import java.util.LinkedList;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> ans = new LinkedList<>();
        boolean isCarry = true;

        for(int i=digits.length-1; i>=0; i--) {
            int cur = digits[i] + (isCarry? 1:0);
            isCarry = cur>=10;
            cur%=10;
            ans.addFirst(cur);
        }

        if(isCarry) {
            ans.addFirst(1);
        }

        int[] ret = new int[ans.size()];
        int i = 0;

        for(int num: ans) {
            ret[i++] = num;
        }

        return ret;
    }
}
