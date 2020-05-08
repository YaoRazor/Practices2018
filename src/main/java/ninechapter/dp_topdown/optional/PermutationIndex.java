package ninechapter.dp_topdown.optional;

public class PermutationIndex {
    public long permutationIndex(int[] A) {
        if(A==null || A.length<2) {
            return 0;
        }

        int n = A.length;

        long[] dp = new long[n+1];

        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1]*i;
        }

        long ans = 0;

        for(int i=0; i<n; i++) {
            long cnt = getSmallerNumbers(A, i);
            ans+= cnt*dp[n-i-1];
        }

        return ans+1;
    }

    private long getSmallerNumbers(int[] A, int cur) {
        int cnt = 0;
        for(int i=cur+1; i<A.length; i++) {
            if(A[i]<A[cur]) {
                cnt++;
            }
        }

        return (long)cnt;
    }
}
