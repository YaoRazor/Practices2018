package ninechapter.optional.optiional;

import java.util.HashMap;
import java.util.Map;

public class SubmatrixSum {

    // This is O(n^3) method, this is a classic problem.
    // We need to memorize this method to do operations in
    // matrix
    public int[][] submatrixSum(int[][] matrix) {
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

        int[][] ans = new int[2][2];


        for(int l=0; l<n; l++) {
            for(int h=l+1; h<=n; h++) {
                Map<Integer, Integer> map = new HashMap<>();
                for(int i=0; i<=m; i++) {
                    int diff = preFixSum[h][i]-preFixSum[l][i];
                    if(map.containsKey(diff)) {
                        int k = map.get(diff);
                        ans[0][0] = l;
                        ans[0][1] = k;
                        ans[1][0] = h-1;
                        ans[1][1] = i-1;
                        return ans;
                    } else {
                        map.put(diff, i);
                    }

                }
            }
        }

        return ans;
    }

}
