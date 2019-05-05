package twodimensionarray;

public class RotateImage {

    public void rotate(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<n; i++) {

            int start = 0;
            int end = m-1;

            while(start<end) {
                swap(matrix, start, i, end, i);
                start++;
                end--;
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=i+1; j<n; j++) {
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
