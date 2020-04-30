package ninechapter.binarysearch;

public class FindPeakElement {
    public int findPeakElement(int[] A) {
        int start = 0;
        int end = A.length-1;

        while(start+1<end) {
            int mid = start+(end-start)/2;

            if(A[mid]<A[mid-1]) {
                end = mid-1;
            } else {
                start = mid;
            }
        }

        return A[start]>A[end]?start:end;
    }
}
