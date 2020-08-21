package ninechapter.optional.optiional;

public class RangeSumQuery2DImutable {
    int[][] prefix;

    public RangeSumQuery2DImutable(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0)         {
            return;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        prefix = new int[n+1][m+1];

        for(int i=0; i<m; i++) {
            prefix[0][i] = 0;
        }

        for(int i=1; i<=n; i++) {
            int sum = 0;
            for(int j=1; j<=m; j++) {
                sum+=matrix[i-1][j-1];
                prefix[i][j] = prefix[i-1][j]+sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2+1][col2+1]-prefix[row2+1][col1]-prefix[row1][col2+1]+prefix[row1][col1];
    }
}
