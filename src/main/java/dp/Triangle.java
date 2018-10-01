package dp;

import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        if(triangle==null || triangle.size()==0) {
            return 0;
        }
        int n = triangle.size();
        int[] dp = new int[n];

        List<Integer> last = triangle.get(n-1);

        for(int i=0; i< last.size(); i++) {

            dp[i] = last.get(i);

        }


        for(int i= n-2; i>=0; i--) {

            List<Integer> cur = triangle.get(i);

            for(int j=0; j<cur.size(); j++) {

                dp[j] = Math.min(dp[j], dp[j+1]) + cur.get(j);

            }

        }

        return dp[0];

    }
}
