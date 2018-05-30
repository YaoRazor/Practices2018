package array;


import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) {
            return digits;
        }

        int carry = 0;
        int tmp = 0;

        int[] result = new int[digits.length+1];

        for(int i=digits.length-1; i>=0; i--) {
            tmp = digits[i]+ carry;
            result[i+1] = tmp%10;
            carry = tmp/10;
        }

        if(carry>0) {
            result[0] = 1;
            return result;
        } else {
            return Arrays.copyOfRange(result, 1, digits.length+1);
        }

    }
}
