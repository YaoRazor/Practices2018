package ninechapter.binarysearch.optional;

// https://www.youtube.com/watch?v=LPFhl65R7ww
// Time complexity is O(log(N))
public class MedianOfTwoSortedArray {

    public double findMedianSortedArrays(int[] A, int[] B) {
        if(A.length>B.length) {
            return findMedianSortedArrays(B, A);
        }

        int x = A.length;
        int y = B.length;

        int start = 0;
        int end = x;

        while(start<=end) {
            int partitionX = (start+end)/2;
            int partitionY = (x+y+1)/2-partitionX;

            int maxLeftX = partitionX==0? Integer.MIN_VALUE: A[partitionX-1];
            int minRightX = partitionX==x? Integer.MAX_VALUE: A[partitionX];

            int maxLeftY = partitionY==0? Integer.MIN_VALUE: B[partitionY-1];
            int minRightY = partitionY==y? Integer.MAX_VALUE: B[partitionY];

            if(maxLeftX<=minRightY && maxLeftY<=minRightX) {
                if((x+y)%2==1) {
                    return Math.max(maxLeftX, maxLeftY);
                } else {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2.0;
                }
            } else if(maxLeftX>minRightY) {
                end = partitionX-1;
            } else {
                start = partitionX+1;
            }
        }

        throw new IllegalArgumentException();
    }
}
