package ninechapter.binarysearch.optional;

public class SearchA2DMatrixTwo {

    public int searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // Use the upper right corner because if you consider first row and
        // last col as an integration part, it can be considered as a sorted
        // array, which can help you exclude half data.
        int row = 0;
        int col = n-1;

        int ans = 0;

        while(row<m && col>=0) {
            if(matrix[row][col]==target) {
                ans++;
                row++;
                col--;
            } else if(matrix[row][col]> target) {
                col--;
            } else {
                row++;
            }
        }

        return ans;
    }
}
