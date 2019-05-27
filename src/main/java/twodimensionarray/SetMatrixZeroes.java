package twodimensionarray;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        boolean isRow = false;
        boolean isColumn = false;

        for(int i=0; i<n; i++) {
            if(matrix[0][i]==0) {
                isRow = true;
            }
        }

        for(int i=0; i<m; i++) {
            if(matrix[i][0]==0) {
                isColumn = true;
            }
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][j]==0) {

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;

                }
            }
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {

                if(matrix[i][0]==0 || matrix[0][j]==0) {
                    matrix[i][j] = 0;
                }

            }
        }

        if(isRow) {
            for(int i=0; i<n; i++) {
                matrix[0][i] = 0;
            }
        }

        if(isColumn) {
            for(int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }

        return;
    }
}
