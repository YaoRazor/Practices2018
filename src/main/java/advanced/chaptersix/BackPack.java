package advanced.chaptersix;

public class BackPack {

    // TC: O(n*m), SC:O(m)
    public int backPack(int m, int[] A) {
        if(A==null || A.length==0 || m==0) {
            return 0;
        }

        int n = A.length;

        boolean[][] dp = new boolean[2][m+1];

        dp[0][0] = true;
        for(int i=1; i<=m; i++) {
            dp[0][i] = false;
        }

        for(int i=1; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                if(j>=A[i-1]) {
                    dp[i%2][j] = dp[(i-1)%2][j] || dp[(i-1)%2][j-A[i-1]];
                } else {
                    dp[i%2][j] = dp[(i-1)%2][j];
                }
            }
        }

        int ans = 0;

        for(int i=m; i>=0; i--) {
            if(dp[n%2][i]) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}
