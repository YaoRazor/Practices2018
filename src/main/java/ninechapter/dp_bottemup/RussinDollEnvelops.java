package ninechapter.dp_bottemup;

import java.util.Arrays;

public class RussinDollEnvelops {
    public int maxEnvelopes(int[][] envelopes) {
        // write your code here
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (a, b) -> compareTo(a, b));
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    private int compareTo(int[] a, int[] b) {
        return  a[0] == b[0]? (a[1] - b[1]) : (a[0] - b[0]);
    }
}
