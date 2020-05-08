package ninechapter.optional.optiional;

import java.util.HashMap;
import java.util.Map;

public class SubmatrixSum {

    // This is O(n^3) method, we can use the most intuitive method, which is O(n^4)
    public int[][] submatrixSum(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) {
            return null;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] prefixSum = new int[n+1][m+1];

        for(int i=0; i<=n; i++) {
            prefixSum[i][0] = 0;
        }

        for(int i=0; i<=m; i++) {
            prefixSum[0][i] = 0;
        }

        int[][] ans = new int[2][2];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                prefixSum[i][j] = matrix[i-1][j-1];
                prefixSum[i][j] += prefixSum[i-1][j];
                prefixSum[i][j] += prefixSum[i][j-1];
                prefixSum[i][j] -= prefixSum[i-1][j-1];
            }
        }

        for(int l=0; l<n; l++) {
            for(int h = l+1; h<=n; h++) {
                Map<Integer, Integer> map = new HashMap<>();
                for(int j=0; j<=m; j++) {
                    int diff = prefixSum[h][j] - prefixSum[l][j];

                    if(map.containsKey(diff)) {
                        int k = map.get(diff);
                        ans[0][0] = l;
                        ans[0][1] = k;
                        ans[1][0] = h-1;
                        ans[1][1] = j-1;
                        return ans;

                    } else {
                        map.put(diff, j);
                    }
                }
            }
        }

        return ans;
    }


    // This is slower than above method, O(n^4)
    public int[][] submatrixSumSlower(int[][] matrix) {
        int[][] prefixSum = new int[matrix.length][matrix[0].length];

        int[][] ans = new int[2][2];
        int n = matrix.length;
        int m = matrix[0].length;


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

        for(int x2=0; x2<n; x2++) {
            for(int y2=0; y2<m; y2++) {
                for(int x1=0; x1<=x2; x1++) {
                    for(int y1=0; y1<=y2; y1++) {
                        if(getSubMatrix(prefixSum, x1, x2, y1, y2)==0){
                            return new int[][]{{x1, y1}, {x2, y2}};
                        }
                    }
                }
            }
        }

        return ans;
        // write your code here
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
