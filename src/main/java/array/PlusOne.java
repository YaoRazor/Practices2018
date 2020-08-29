package array;

import java.util.LinkedList;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> ans = new LinkedList<>();
        int carry = 1;

        for(int i=digits.length-1; i>=0; i--) {
            int cur = digits[i] + carry;
            ans.addFirst(cur%10);
            carry = cur/10;
        }

        if(carry > 0) {
            ans.addFirst(carry);
        }

        int[] ret = new int[ans.size()];
        int i = 0;

        for(int num: ans) {
            ret[i++] = num;
        }

        return ret;
    }
}
