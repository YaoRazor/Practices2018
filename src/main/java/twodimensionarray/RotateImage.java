package twodimensionarray;

public class RotateImage {

    // 先上下flip，再对角线flip. 如果是anticlockwise，就先左右flip, 然后对角线flip
    public void rotate(int[][] matrix) {

        for(int i=0; i<matrix[0].length; i++) {

            int start = 0;
            int end = matrix.length-1;

            while(start<end) {
                swap(matrix, start, i, end, i);
                start++;
                end--;
            }

        }

        for(int i=0; i<matrix.length; i++) {
            for(int j=i+1; j<matrix[0].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }

    }

    private void swap(int[][] matrix, int i, int j, int n, int k) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[n][k];
        matrix[n][k] = tmp;

    }
}
