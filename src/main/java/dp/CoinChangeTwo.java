package dp;


public class CoinChangeTwo {


    public int change(int amount, int[] coins) {

        int[] dp = new int[amount+1];

        dp[0] = 1;

        for(int i=1; i<=coins.length; i++) {
            dp[0] = 1;

            for(int j= coins[i-1]; j<=amount; j++) {

                dp[j] = dp[j] + (j>=coins[i-1]? dp[j-coins[i-1]]: 0);

            }

        }

        return dp[amount];

    }

}
