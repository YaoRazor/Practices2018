package matrix;

public class SpiralMatrixTwo {
    public int[][] generateMatrix(int n) {
        if(n<=0) {
            return new int[][]{};
        }

        int cnt = 1;
        int[][] matrix = new int[n][n];
        int left = 0, right = n-1;
        int top = 0, bottem = n-1;

        while(cnt<=n*n) {
            for(int i=left; i<=right; i++) {
                matrix[top][i]=cnt++;
            }
            top++;


            for(int i=top; i<=bottem; i++) {
                matrix[i][right]=cnt++;
            }

            right--;

            if(top<=bottem) {
                for(int i=right; i>=left; i--) {
                    matrix[bottem][i] = cnt++;
                }

                bottem--;
            }

            if(left<=right) {
                for(int i=bottem; i>=top; i--) {
                    matrix[i][left] = cnt++;
                }
                left++;
            }
        }
        return matrix;
    }
}
