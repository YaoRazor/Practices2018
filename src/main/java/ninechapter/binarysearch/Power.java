package ninechapter.binarysearch;


public class Power {

    public double myPow(double x, int n) {
        return myLongPow(x, (long)n);
    }

    // Using LongPow function is to handle an edge case that
    // is n == -2147483648
    public double myLongPow(double x, long n) {
        if(n==0) {
            return 1;
        } else if(n==1) {
            return x;
        } else if(n<0) {
            return 1/myLongPow(x, 0l-n);
        }

        double tmp = x;
        double ans = 1;

        // x^n = (x^2)^(n/2)
        while(n>0){
            if(n%2==1)  {
                ans *=tmp;
            }

            tmp = tmp*tmp;
            n/=2;
        }

        return ans;
    }

}
