package ninechapter.binarysearch;


public class FirstBadVersion {

    public int findFirstBadVersion(int n) {
        int start = 0;
        int end = n;

        while(start+1<end) {
            int mid = start+(end-start)/2;

            if(isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return isBadVersion(start)? start:end;
    }

    boolean isBadVersion(int version) {
        return false;
    }
}
