package ninechapter.binarysearch;


public class Power {

    public double myPow(double x, int n) {
        // Using long version is to prevent overflow issue when
        // n is -2147483648
        return myLongPow(x, (long)n);
    }

    public double myLongPow(double x, long n) {
        // n<0 is a special case.
        if(n<0) {
            return 1d/myLongPow(x, 0l-n);
        }

        double tmp = x;
        double ans = 1;

        // n==0 and n==1 case will be handled by this logic
        while(n>0) {
            if(n%2==1) {
                ans*=tmp;
            }

            tmp = tmp*tmp;
            n/=2;
        }

        return ans;
    }

}
