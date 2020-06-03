package ninechapter.binarysearch.optional;

public class DivideTwoInteger {

    // TC: O(31+30+....+1) --> O(1)
    public int divide(int dividend, int divisor) {
        long did = (long)dividend;
        long div = (long)divisor;
        boolean isNegative = false;

        if(did*div<0) {
            isNegative = true;
        }

        did = Math.abs(did);
        div = Math.abs(div);

        long ans = 0;

        while(did>=div) {
            long tmp = div;
            long x = 1;
            while(did>=(tmp<<1)) {
                tmp<<=1;
                x<<=1;
            }

            ans+=x;
            did-=tmp;
        }

        if(isNegative) {
            return (int)(0l-ans);
        } else {
            if(ans>=Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int)ans;
            }
        }
    }
}
