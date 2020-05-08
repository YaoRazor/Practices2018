package ninechapter.optional.optiional;

public class MergeTwoSortedArrays {
    public int[] mergeSortedArray(int[] A, int[] B) {
        if(A==null || A.length==0) {
            return B;
        }

        if(B==null || B.length==0) {
            return A;
        }

        int i = 0;
        int j = 0;
        int k = 0;
        int[] ans = new int[A.length+B.length];

        while(i<A.length && j<B.length) {
            if(A[i]<=B[j]) {
                ans[k++] = A[i++];
            } else {
                ans[k++] = B[j++];
            }
        }

        while(i<A.length) {
            ans[k++] = A[i++];
        }

        while(j<B.length) {
            ans[k++] = B[j++];
        }

        return ans;
    }
}
