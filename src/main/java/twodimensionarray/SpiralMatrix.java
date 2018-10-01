package twodimensionarray;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) {
            return ans;
        }

        int m = matrix[0].length;
        int n = matrix.length;

        int top = 0; int down = n-1;
        int left = 0; int right = m-1;

        while (true) {

            for(int i=left; i<=right; i++) {
                ans.add(matrix[top][i]);
            }

            if(++top>down) {
                break;
            }

            for(int i=top; i<=down; i++) {
                ans.add(matrix[i][right]);
            }

            if(--right<left) {
                break;
            }


            for(int i=right; i>=left; i--) {
                ans.add(matrix[down][i]);
            }

            if(--down<top) {
                break;
            }


            for(int i=down; i>=top; i--) {
                ans.add(matrix[i][left]);
            }

            if(++left>right) {
                break;
            }

        }

        return ans;
    }
}
