package ninechapter.binarysearch.optional;

public class ClosestNumberInSortedArray {
    public int closestNumber(int[] A, int target) {
        if(A==null || A.length==0) {
            return -1;
        }

        int start = 0;
        int end = A.length-1;

        while(start+1<end) {
            int mid = (start+end)/2;
            if(A[mid]>target) {
                end = mid-1;
            } else {
                start = mid;
            }
        }

        int left = -1;
        int right = -1;

        if(A[end]<=target) {
            left = end;
        } else {
            left = start;
        }

        start = 0;
        end = A.length-1;

        while(start+1<end) {
            int mid = (start+end)/2;
            if(A[mid]<target) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        if(A[start]>=target){
            right = start;
        } else {
            right = end;
        }

        System.out.println("left is "+left+" right is "+right);
        if(Math.abs(A[left]-target)>Math.abs(A[right]-target)){
            return right;
        } else {
            return left;
        }

    }
}
