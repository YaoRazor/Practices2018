package ninechapter.binarysearch;

// TC: O(logn) SC: O(1)
public class FirstBadVersion {

    public int findFirstBadVersion(int n) {
        int start = 1;
        int end = n;

        while(start<end) {
            // Using (start+end)/2 is similar from algorithm perspective,
            // but it won't pass for very large numbers unless we cast
            // the type to long
            int mid = (end-start)/2+start;
            if(isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return start;
    }

    boolean isBadVersion(int version) {
        return false;
    }
}
