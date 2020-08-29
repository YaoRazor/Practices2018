package matrix;

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

        // 前两个for loop的条件被while循环的条件所保证了，
        // 但是第三和第四个for loop在前两个loop运行后有可能
        // 不满足原来的条件
        while(left<=right && top<=bottem) {
            for(int i=left; i<=right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;


            for(int i=top; i<=bottem; i++) {
                ans.add(matrix[i][right]);
            }

            right--;

            // 原矩阵只剩一行的时候如果没有外层的条件会有问题
            if(top<=bottem) {
                for(int i=right; i>=left; i--) {
                    ans.add(matrix[bottem][i]);
                }

                bottem--;
            }

            // 原矩阵只剩一列的时候如果没有外层的条件会有问题
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
