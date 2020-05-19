package ninechapter.dp_bottemup.optional;

import java.util.Arrays;

public class FrogJump {
    public boolean canCross(int[] stones) {
        if(stones==null || stones.length<2) {
            return true;
        }

        // dp[i][j] represents whether we can jump from i to j and get to final position eventually
        boolean[][] dp = new boolean[stones.length][stones.length];
        boolean[][] visited = new boolean[stones.length][stones.length];

        return dfs(stones, 0, 1, dp, visited);
    }

    private boolean dfs(int[] stones, int from, int to, boolean[][] dp, boolean[][] visited) {
        if(visited[from][to]) {
            return dp[from][to];
        }

        if(to==stones.length-1) {
            visited[from][to] = true;
            dp[from][to] = true;
            return true;
        }

        visited[from][to] = true;

        int step = stones[to] - stones[from];

        for(int j=to+1; j<stones.length; j++) {

            int difference = stones[j]-stones[to];
            if(difference>step+1) {
                break;
            }

            if(difference>=step-1) {

                if(dfs(stones, to, j, dp, visited)) {
                    dp[from][to] = true;
                    return true;
                }
            }
        }

        dp[from][to] = false;

        return false;
    }
}
