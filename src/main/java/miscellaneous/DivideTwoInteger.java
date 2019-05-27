package miscellaneous;

public class DivideTwoInteger {
    public int divide(int dividend, int divisor) {
        long did = (long)dividend;
        long div = (long)divisor;

        long sign = did*div<0? -1:1;

        did = Math.abs(did);
        div = Math.abs(div);

        long ans = 0;

        while(did>=div) {
            long tmp = div; long step = 1;

            while(did>=(tmp<<1)) {
                tmp = tmp<<1;
                step = step<<1;
            }

            did -=tmp;
            ans+=step;
        }

        int ret;

        if (ans > Integer.MAX_VALUE){ //Handle overflow.
            ret = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ret = (int) (sign * ans);
        }
        return ret;
    }
}
