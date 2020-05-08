package ninechapter.optional;

// The key point is to copy from end to start
public class MergeSortedArray {

    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i>=0 && j>=0) {
            if(A[i]>=B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }

        if(j<0) {
            return;
        }

        while(j>=0) {
            A[k--] = B[j--];
        }
    }
}
