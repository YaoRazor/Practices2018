package bst;

/**
 * Created by yawang on 3/11/18.
 */
class VersionControl {
    boolean isBadVersion(int version) {
        return false;
    }
}


public class FirstBadVersion extends VersionControl{
    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;
        while (left < right) {
            //不要用加，而是用left + (right - left) / 2，可以去除overflow的问题
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left; // right也可以，eventually left and right will meet

    }
}
