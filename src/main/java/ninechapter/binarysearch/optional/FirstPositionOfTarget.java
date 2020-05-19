package ninechapter.binarysearch.optional;

public class FirstPositionOfTarget {
    public int binarySearch(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int n = A.length;

        int start = 0;
        int end = n - 1;

        while (start + 1 < end) {
            int mid = (start + end) / 2;

            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if(A[start]==target) {
            return start;
        }

        if(A[end]==target) {
            return end;
        }

        return -1;
    }
}
