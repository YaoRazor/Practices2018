package ninechapter.dp_topdown;

import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        for(int i=0; i<n; i++) {
            dp[i] = triangle.get(n-1).get(i);
        }

        for(int i=n-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                dp[j] = Math.min(dp[j], dp[j+1])+triangle.get(i).get(j);
            }
        }

        return dp[0];
    }

    public int minimumTotal(int[][] triangle) {
        if(triangle==null || triangle.length==0) {
            return 0;
        }
        int[][] dp = new int[triangle.length][triangle.length];
        boolean[][] visitied = new boolean[triangle.length][triangle.length];
        return getMintotal(triangle, 0, 0, dp, visitied);
    }

    private int getMintotal(int[][] triangle, int x, int y, int[][] dp, boolean[][] visitied) {
        if(visitied[x][y]) {
            return dp[x][y];
        }

        if(x==triangle.length-1) {
            dp[x][y] = triangle[x][y];
            visitied[x][y] = true;
            return dp[x][y];
        }

        int left = getMintotal(triangle, x+1, y, dp, visitied);
        int right = getMintotal(triangle, x+1, y+1, dp, visitied);

        int total = Math.min(left, right)+triangle[x][y];
        dp[x][y] = total;
        visitied[x][y] = true;
        return total;
    }
}
