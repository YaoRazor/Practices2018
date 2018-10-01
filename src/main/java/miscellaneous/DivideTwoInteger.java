package miscellaneous;

public class DivideTwoInteger {

    public int divide(int dividend, int divisor) {


        // Below are the two edge cases that need to be handled

        if(dividend==Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if(dividend==Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }


        boolean isNegative = (dividend>0 && divisor<0) || (dividend<0 && divisor>0);


        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);

        int ans = 0;

        while (dvd>=dvs) {
            long tmp = dvs; long bit = 1;

            while (dvd>=(tmp<<1)) {
                tmp = tmp<<1;
                bit = bit<<1;
            }

            dvd-= tmp;
            ans+=bit;
        }


        if(isNegative) {
            return -ans;
        } else {
            return ans;
        }

    }
}
