package dp;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        ResultType[][] dp = new ResultType[n][n];
        ResultType result = getStones(piles, 0, piles.length-1, dp);
        return result.first>result.second;
    }

    private ResultType getStones(int[] piles, int i, int j, ResultType[][] dp) {

        if(dp[i][j]!=null) {
            return dp[i][j];
        }

        if(i==j) {
            dp[i][i] = new ResultType(piles[i], 0);
            return dp[i][i];
        }

        ResultType left = getStones(piles, i+1, j, dp);
        ResultType right = getStones(piles, i, j-1, dp);

        if(left.second+ piles[i]>right.second+piles[j]) {
            dp[i][j] = new ResultType(left.second+ piles[i], left.first);
        } else {
            dp[i][j] = new ResultType(right.second+ piles[j], right.first);
        }

        return dp[i][j];
    }

    class ResultType {
        public int first;
        public int second;

        public ResultType(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
