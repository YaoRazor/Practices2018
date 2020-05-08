package ninechapter.dp_topdown.optional;


import java.util.HashMap;
import java.util.Map;

public class PermutationIndexTwo {
    public long permutationIndexII(int[] A) {
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
            long redundent = 1;
            long cnt = 0;
            Map<Integer, Integer> map = new HashMap<>();
            // Consider array from index i to n-1 as a whole array
            map.put(A[i], 1);

            for(int j=i+1; j<n; j++) {
                map.put(A[j], map.getOrDefault(A[j], 0)+1);
                redundent *= map.get(A[j]);
                if(A[i]>A[j]) {
                    cnt++;
                }
            }

            // Since for the first position, we can not use any number, so we reduce that
            // from n-i to cnt. And for redundent, we will consider position i as well.
            // So think about this problem in the following way: we are trying to get the total
            // factorial between position i to n-1 with the restriction that on postion i, we can
            // only place the numbers that are smaller than A[i]
            ans+= dp[n-i-1]*cnt/redundent;
        }

        return ans+1;
    }

}
