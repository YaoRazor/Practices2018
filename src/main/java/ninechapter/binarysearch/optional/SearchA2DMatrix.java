package ninechapter.binarysearch.optional;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m*n-1;

        while(start<end) {
            int mid = (start+end)/2;
            int x = mid/n;
            int y = mid%n;

            if(target == matrix[x][y]) {
                return true;
            } else if(target>matrix[x][y]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return matrix[start/n][start%n]==target;
    }

}
