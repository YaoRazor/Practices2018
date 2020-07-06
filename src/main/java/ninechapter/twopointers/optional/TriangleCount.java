package ninechapter.twopointers.optional;

import java.util.Arrays;

// TC: O(n^2)
public class TriangleCount {
    public int triangleCount(int[] S) {
        if(S==null || S.length<3) {
            return 0;
        }

        Arrays.sort(S);
        int n = S.length;

        int ans = 0;

        for(int i=n-1; i>=2; i--) {
            int j = 0;
            int k = i-1;

            while(j<k) {
                if(S[j]+S[k]>S[i]) {
                    ans+=k-j;
                    k--;
                } else {
                    j++;
                }
            }
        }

        return ans;
    }
}
