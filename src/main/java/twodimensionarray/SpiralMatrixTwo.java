package twodimensionarray;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixTwo {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int top = 0; int down = n-1;
        int left = 0; int right = n-1;

        int number = 1;

        while (true) {

            for (int i = left; i <= right; i++) {
                matrix[top][i] = number++;
            }

            if(++top>down) {
                break;
            }


            for (int i = top; i <= down; i++) {
                matrix[i][right] = number++;
            }

            if(--right<left) {
                break;
            }


            for (int i = right; i >= left; i--) {
                matrix[down][i] = number++;
            }

            if(--down<top) {
                break;
            }


            for (int i = down; i >= top; i--) {
                matrix[i][left] = number++;

            }

            if(++left>right) {
                break;
            }
        }

        return matrix;

    }
}
