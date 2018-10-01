package array;

public class RotateString {
    public boolean rotateString(String A, String B) {
        if(A.length()!=B.length()) {
            return false;
        }

        if(A.equals(B)) {
            return true;
        }

        int n = A.length();

        for(int i=1; i<n; i++ ) {

            if(A.substring(0, i).equals(B.substring(n-i)) && A.substring(i).equals(B.substring(0,n-i))) {
                return true;
            }

        }

        return false;

    }
}
