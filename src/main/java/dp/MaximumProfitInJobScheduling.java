package dp;

import java.util.Arrays;

public class MaximumProfitInJobScheduling {

    // use n as the nth job instead of time n as the variable which makes
    // the array length smaller. The problem then becomes: should we take
    // the nth job or not
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        int[] dp = new int[jobs.length];
        dp[jobs.length-1] = jobs[jobs.length - 1][2];

        for(int i=jobs.length-2; i>=0; i--) {
            dp[i] = dp[i+1];
            int next = findNext(i, jobs, dp);
            dp[i] = Math.max(dp[i], next+jobs[i][2]);
        }

        return dp[0];
    }

    int findNext(int cur, int[][] jobs, int[] dp) {
        for(int i=cur+1; i<jobs.length; i++) {
            if(jobs[i][0]>=jobs[cur][1]) {
                return dp[i];
            }
        }

        return 0;
    }
}
