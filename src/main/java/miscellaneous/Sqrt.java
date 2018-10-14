package miscellaneous;

public class Sqrt {
    public int mySqrt(int x) {

        // Adding this because we are using divide operation to avoid issue of overflow
        // when x is 0 or 1, the divisor can be 0;
        if(x<=1) {
            return x;
        }

        int start = 0;
        int end = x;

        while(start<end) {
            int mid = (end-start)/2 + start;

            // Using this to avoid overflow
            if(x/mid>=mid && x/(mid+1)<(mid+1)) {
                return mid;
            } else if(x/mid>mid) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return start;

    }
}
