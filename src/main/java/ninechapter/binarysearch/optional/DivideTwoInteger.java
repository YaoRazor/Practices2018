package ninechapter.binarysearch.optional;

public class DivideTwoInteger {

    public int divide(int dividend, int divisor) {
        long did = (long) dividend;
        long div = (long) divisor;

        // handle sign
        boolean isNegative = false;

        if(did*div<0) {
            isNegative = true;
        }

        // do not forget about this step
        did = Math.abs(did);
        div = Math.abs(div);

        long ans = 0;

        while(did>=div) {
            long step = 1;
            long tmp = div;

            while(did>=(tmp<<1)) {
                tmp=tmp<<1;
                step=step<<1;
            }

            ans+=step;
            did-=tmp;
        }

        // Handle overflow
        if(ans>=Integer.MAX_VALUE) {
            if(isNegative) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        } else {
            if(isNegative) {
                return 0-(int)ans;
            } else {
                return (int)ans;
            }
        }
    }
}
