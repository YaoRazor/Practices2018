package advanced.chapterfour;

public class SqrtTwo {

    public double sqrt(double x) {
        double start = 0;
        // When x<1, sqrt(x) can be bigger than x, but not bigger than 1
        // this is a special case
        double end = Math.max(x,1);

        while(end-start>=1e-10) {
            double mid = (end+start)/2;
            if(mid*mid<=x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
