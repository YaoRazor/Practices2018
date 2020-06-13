package advanced.chapterseven;

public class SlidingWindowMatrixMaximum {

    // TC:O(n^2), SC: O(n^2)
    // 二维前缀和问题，和SubMatrixSum两道题结合起来看一下
    public int maxSlidingMatrix(int[][] matrix, int k) {
        if(matrix==null || matrix[0]==null || matrix.length<k || matrix[0].length<k) {
            return 0;
        }

        int ans = Integer.MIN_VALUE;

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] preFixSum = new int[n+1][m+1];

        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                if(i==0 || j==0) {
                    preFixSum[i][j] = 0;
                } else {
                    preFixSum[i][j] = matrix[i-1][j-1] + preFixSum[i-1][j] + preFixSum[i][j-1] - preFixSum[i-1][j-1];
                }
            }
        }

        for(int i=0; i+k<=n; i++) {
            for(int j=0; j+k<=m; j++) {
                int cur = preFixSum[i+k][j+k]-preFixSum[i][j+k]-preFixSum[i+k][j]+preFixSum[i][j];
                ans = Math.max(ans, cur);
            }
        }

        return ans;
    }
}
