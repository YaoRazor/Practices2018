package ninechapter.optional;

public class MaximumSubmatrix {
    public int maxSubmatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) {
            return 0;
        }

        int n = matrix.length;

        int[][] preSum = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                preSum[i][j] = matrix[i][j];
                if(i>0) {
                    preSum[i][j] += preSum[i-1][j];
                }

                if(j>0) {
                    preSum[i][j] += preSum[i][j-1];
                }

                if(i>0&&j>0) {
                    preSum[i][j] -= preSum[i-1][j-1];
                }
            }
        }

        int ans = matrix[0][0];

        for(int x2=0; x2<n; x2++) {
            for(int y2=0; y2<n; y2++) {
                for(int x1=0; x1<=x2; x1++) {
                    for(int y1=0; y1<=y2; y1++) {
                        ans = Math.max(ans, getSubMatrix(preSum, x1, x2, y1, y2));
                    }
                }
            }
        }

        return ans;
    }


    private int getSubMatrix(int[][] preSum, int x1, int x2, int y1, int y2) {
        int ans = preSum[x2][y2];

        if(y1>0) {
            ans -= preSum[x2][y1-1];
        }

        if(x1>0) {
            ans -= preSum[x1-1][y2];
        }

        if(x1>0 && y1>0) {
            ans+=preSum[x1-1][y1-1];
        }

        return ans;
    }
}
