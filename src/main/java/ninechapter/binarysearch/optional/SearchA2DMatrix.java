package ninechapter.binarysearch.optional;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) {
            return false;
        }

        int start = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int end = m*n-1;

        while(start<=end) {
            int mid = (end-start)/2+ start;
            int i = mid/n;
            int j = mid%n;

            if(matrix[i][j]==target) {
                return true;
            } else if(matrix[i][j]<target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return false;
    }

}
