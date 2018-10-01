package binarysearch;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null || matrix.length==0 || matrix[0].length==0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int start = 0;
        int end = row*column-1;

        while(start<=end) {
            int mid = (start+end)/2;

            // Both are column, pay attention to it
            int x = mid/column;
            int y = mid%column;

            if(matrix[x][y]==target) {
                return true;
            } else if(matrix[x][y]>target) {
                end = mid-1;
            } else {
                start = mid+1;
            }


        }

        return false;

    }

}
