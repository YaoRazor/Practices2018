package advanced.chapterseven;

public class SubArraySumTwo {

    // TC: O(N), SC:O(N)
    public int subarraySumII(int[] A, int start, int end) {
        if(A==null || A.length==0) {
            return 0;
        }

        int[] sum = new int[A.length+1];
        sum[0] = 0;
        for(int i=1; i<=A.length; i++) {
            sum[i] = sum[i-1]+A[i-1];
        }
        int ans=0, l=0, r=0;

        for(int i=0; i<=A.length; i++) {
            while(l<i && sum[i]-sum[l]>end) {
                l++;
            }

            while(r<i && sum[i]-sum[r]>=start) {
                r++;
            }

            ans+=r-l;
        }

        return ans;
    }
}
