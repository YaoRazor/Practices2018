package ninechapter.binarysearch;

// TC: O(logn)
public class FirstBadVersion {

    public int findFirstBadVersion(int n) {
        int start = 1;
        int end = n;

        while(start<end) {
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
