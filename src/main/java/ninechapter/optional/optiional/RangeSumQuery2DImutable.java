package ninechapter.optional.optiional;

public class RangeSumQuery2DImutable {
    int[][] matrix;
    int[][] prefixSum;

    public RangeSumQuery2DImutable(int[][] matrix) {
        this.matrix = matrix;
        prefixSum = new int[matrix.length][matrix[0].length];

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                prefixSum[i][j] = matrix[i][j];
                if(i>0) {
                    prefixSum[i][j] += prefixSum[i-1][j];
                }
                if(j>0) {
                    prefixSum[i][j] += prefixSum[i][j-1];
                }
                if(i>0 && j>0) {
                    prefixSum[i][j] -= prefixSum[i-1][j-1];
                }
            }
        }

    }

    public int sumRegion(int x1, int y1, int x2, int y2) {
        int ans = prefixSum[x2][y2];
        if(x1>0) {
            ans-= prefixSum[x1-1][y2];
        }

        if(y1>0) {
            ans-= prefixSum[x2][y1-1];
        }

        if(x1>0 && y1>0) {
            ans += prefixSum[x1-1][y1-1];
        }

        return ans;
    }
}
