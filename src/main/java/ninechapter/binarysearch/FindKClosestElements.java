package ninechapter.binarysearch;

public class FindKClosestElements {
    public int[] kClosestNumbers(int[] A, int target, int k) {
        int index = findClosestIndex(A, target);
        System.out.println("index is "+index);
        return findKNumbers(A, target, k, index);
    }

    private int[] findKNumbers(int[] A, int target, int k, int index) {
        int left = index;
        int right = index+1;

        int[] ans = new int[k];
        int i=0;

        while(i<k) {
            if(right==A.length || left>=0 && Math.abs(A[left]-target)<=Math.abs(A[right]-target)) {
                ans[i++] = A[left--];
            } else {
                ans[i++] = A[right++];
            }
        }

        return ans;
    }


    private int findClosestIndex(int[] A, int target) {
        int start = 0;
        int end = A.length-1;

        while(start+1<end) {
            int mid = start+(end-start)/2;

            if(A[mid]<=target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if(Math.abs(A[end]-target)>=Math.abs(A[start]-target)) {
            return start;
        } else {
            return end;
        }
    }
}
