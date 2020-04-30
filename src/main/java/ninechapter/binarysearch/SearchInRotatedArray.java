package ninechapter.binarysearch;

public class SearchInRotatedArray {

    public int search(int[] A, int target) {
        if(A==null || A.length==0) {
            return -1;
        }

        int start = 0;
        int end = A.length-1;

        while(start+1<end) {
            int mid = start+(end-start)/2;

            if(A[mid]>A[start]) {
                if(target<=A[mid] && target>=A[start]) {
                    end = mid;
                } else {
                    start = mid+1;
                }
            } else {
                if(target<=A[end] && target>=A[mid]) {
                    start = mid;
                } else {
                    end = mid-1;
                }
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
