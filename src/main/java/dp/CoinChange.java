package dp;

import java.util.Arrays;

// TC: O(amount*coins.length)
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1]; // This is a keypoint that set the initial value as amount+1

        Arrays.fill(dp, amount+1);
        // this is optional.
        Arrays.sort(coins);
        dp[0] = 0;

        for(int i=1; i<=amount; i++) {
            // 通过对于只有coin值进行循环可以剪枝，具体可以对比solution two
            for(int j=0; j<coins.length; j++) {
                if(i>=coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                } else {
                    break; // Because you did a sort in the beginning, therefore you can trim branch here
                }
            }
        }

        return dp[amount]==amount+1? -1: dp[amount];
    }

    public int coinChangeTwo(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        // Set<Integer> set = new HashSet<>();
        for(int coin: coins) {
            // set.add(coin);
            if(coin<=amount) {
                dp[coin] = 1;
            }
        }

        for(int i=1; i<=amount; i++) {
            for(int j=0; j<i; j++) {
                if(dp[i]>dp[j]+dp[i-j]) {
                    dp[i] = dp[j]+dp[i-j];
                }
            }
        }

        return dp[amount]==amount+1? -1: dp[amount];
    }
}
