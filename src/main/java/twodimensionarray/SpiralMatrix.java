package twodimensionarray;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) {
            return ans;
        }

        int left = 0, right = matrix[0].length-1;
        int top = 0, bottem = matrix.length-1;

        while(left<=right && top<=bottem) {
            if(top<=bottem) {
                for(int i=left; i<=right; i++) {
                    ans.add(matrix[top][i]);
                }
                top++;
            }

            if(left<=right) {
                for(int i=top; i<=bottem; i++) {
                    ans.add(matrix[i][right]);
                }

                right--;
            }

            if(top<=bottem) {
                for(int i=right; i>=left; i--) {
                    ans.add(matrix[bottem][i]);
                }

                bottem--;
            }

            if(left<=right) {
                for(int i=bottem; i>=top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
}
