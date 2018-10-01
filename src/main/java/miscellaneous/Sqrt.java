package miscellaneous;

public class Sqrt {
    public int mySqrt(int x) {

        long start = 0;
        long end = x/2+1;


        while (start<=end) {

            long mid = (start+end)/2;

            if(mid*mid<=x && (mid+1)*(mid+1)>x) {
                return (int)mid;
            } else if(mid*mid<x) {
                start = mid+1;
            } else {
                end = mid-1;
            }

        }

        return -1;

    }
}
