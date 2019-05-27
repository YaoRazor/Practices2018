package miscellaneous;


public class Power {

    public double myPow(double x, int n) {
        if(n > 0) {
            return myPositivePower(x, n);
        } else {
            return 1/myPositivePower(x, 0-n);
        }
    }

    private double myPositivePower(double x, int n) {
        if(n==0) {
            return 1;
        }

        double half = myPositivePower(x, n/2);

        if(n%2==0) {
            return half*half;
        } else {
            return x*half*half;
        }
    }

}
