package advanced.chaptersix.optional;

public class BackPackThree {

    //一维
    public int backPackIII(int[] A, int[] V, int m) {
        if(A==null || A.length==0) {
            return 0;
        }

        int n = A.length;
        int[] dp = new int[m+1];

        for(int i=1; i<=n; i++) {
            for(int j=A[i-1]; j<=m; j++) {
//                if(j>=A[i-1]) {
                    dp[j] = Math.max(dp[j], dp[j-A[i-1]]+V[i-1]);
//                }
            }
        }

        int ans = 0;

        for(int i=1; i<=m; i++) {
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }


    //二维
    public int backPackIIITwoDimension(int[] A, int[] V, int m) {
        if(A==null || A.length==0) {
            return 0;
        }

        int n = A.length;

        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=m; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=A[i-1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-A[i-1]]+V[i-1]);
                }
            }
        }

        int ans = 0;

        for(int i=1; i<=m; i++) {
            ans = Math.max(ans, dp[n][i]);
        }

        return ans;
    }



}
