package dp;


public class ClimbingStairs {
    public int climbStairs(int n) {

        int[] pre = new int[2];
        pre[0] = 1;
        pre[1] = 1;

        if(n==1) {
            return 1;
        }

        int ans = 0;

        for(int i=2; i<=n; i++) {
            ans = pre[0] + pre[1];
            pre[i%2] = ans;
        }

        return ans;
    }
}
