package binarysearch;

public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if((m+n)%2==0) {
            return (findKth(nums1, 0, m-1, nums2, 0, n-1, (m+n)/2) + findKth(nums1, 0, m-1, nums2, 0, n-1, (m+n)/2+1))/2;
        } else {
            return findKth(nums1, 0, m-1, nums2, 0, n-1, (m+n)/2+1);
        }

    }


    // find kth smallest element
    private double findKth(int[] A, int startA, int endA, int[] B, int startB, int endB, int k) {

        int m = endA-startA+1;
        int n = endB-startB+1;

        if(m>n) {
            return findKth(B, startB, endB, A, startA, endA, k);
        } else if(m==0) {
            return B[startB+k-1];
        } else if(k==1) {
            return Math.min(A[startA], B[startB]);
        }

        int partA = Math.min(k/2, m);
        int partB = k-partA;

        if(A[startA+partA-1]< B[startB+partB-1]) {

            return findKth(A, startA+partA, endA, B, startB, endB, k-partA);

        } else if(A[startA+partA-1]> B[startB+partB-1]) {
            return findKth(A, startA, endA, B, startB+partB, endB, k-partB);
        } else {
            return A[startA+partA-1];
        }

    }
}
