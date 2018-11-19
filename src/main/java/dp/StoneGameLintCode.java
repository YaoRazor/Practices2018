package dp;

public class StoneGameLintCode {


    // i倒序循环，j正向循环
    public int stoneGame(int[] A) {

        if(A==null || A.length==0) {
            return 0;
        }

        int[] prefixSum = new int[A.length];
        prefixSum[0] = A[0];

        for(int i=1; i<A.length; i++) {
            prefixSum[i] = A[i]+prefixSum[i-1];
        }

        int[][] dp = new int[A.length][A.length];

        for(int i=A.length-1; i>=0; i--) {

            for(int j=i; j<A.length; j++) {

                if(j==i) {
                    dp[i][i] = 0;
                    continue;
                }

                dp[i][j] = Integer.MAX_VALUE;

                for(int k=i; k<j; k++) {

                    dp[i][j] = Math.min(prefixSum[j]-prefixSum[i]+A[i]+dp[i][k] + dp[k+1][j], dp[i][j]);

                }


            }


        }

        return dp[0][A.length-1];

    }

    // Use range
    public int stoneGame2(int[] A) {

        if(A==null || A.length==0) {
            return 0;
        }

        int[] prefixSum = new int[A.length];
        prefixSum[0] = A[0];

        for(int i=1; i<A.length; i++) {
            prefixSum[i] = A[i]+prefixSum[i-1];
        }

        int[][] dp = new int[A.length][A.length];

        for(int range=1; range<=A.length; range++) {

            // 注意i要比A.length-range+1小，j每次只有一个值, j其实是由range决定的
            for(int i=0; i<A.length-range+1; i++) {

                int j = i+range-1;

                if(j==i) {
                    dp[i][i] = 0;
                    continue;
                }

                dp[i][j] = Integer.MAX_VALUE;

                for(int k=i; k<j; k++) {

                    dp[i][j] = Math.min(prefixSum[j]-prefixSum[i]+A[i]+dp[i][k] + dp[k+1][j], dp[i][j]);

                }


            }


        }


        return dp[0][A.length-1];



        // write your code here
    }


}
