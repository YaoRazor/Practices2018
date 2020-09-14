package companies.facebook;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        boolean inc = true;
        boolean dec = true;

        for(int i=1; i<A.length; i++) {
            inc &= A[i]>=A[i-1];
            dec &= A[i]<=A[i-1];
            if(!inc && !dec) {
                return false;
            }
        }

        return true;
    }
}
