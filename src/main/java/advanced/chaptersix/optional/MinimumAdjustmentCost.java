package advanced.chaptersix.optional;

import java.util.List;

public class MinimumAdjustmentCost {

    public int MinAdjustmentCost(List<Integer> A, int target) {
        if(A==null || A.size()<2) {
            return 0;
        }

        int n = A.size();
        int[][] dp = new int[n+1][101];

        for(int i=1; i<=100; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<101; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                for(int k=j-target; k<=j+target; k++) {
                    if(k<1 || k>100) {
                        continue;
                    }

                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k]+ Math.abs(j-A.get(i-1)));
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int i=1; i<=100; i++) {
            ans = Math.min(ans, dp[n][i]);
        }

        return ans;
    }
}
