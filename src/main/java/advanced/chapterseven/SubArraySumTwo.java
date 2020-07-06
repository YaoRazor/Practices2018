package advanced.chapterseven;

public class SubArraySumTwo {

    // TC: O(N), SC:O(N)
    // Using right pointer as main pointer is much easier
    // if we use left pointer as the main pointer, there
    // will be many more edge cases to consider
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

    public int subarraySumIIUsingLeftPointerAsMain(int[] A, int start, int end) {
        if(A==null || A.length==0) {
            return 0;
        }

        int n = A.length;

        int[] preFiSum = new int[n+1];
        preFiSum[0] = 0;

        for(int i=1; i<=n; i++) {
            preFiSum[i] = preFiSum[i-1]+A[i-1];
        }

        int j = 1;
        int k = 1;

        int sum = 0;

        for(int i=0; i<n; i++) {
            while((preFiSum[j]-preFiSum[i]<start) && j<n) {
                j++;
            }

            if(preFiSum[j]-preFiSum[i]<start) {
                break;
            }

            // this is smaller than or equals
            while(preFiSum[k]-preFiSum[i]<=end && k<n) {
                k++;
            }

            if(preFiSum[k]-preFiSum[i]<=end) {
                sum+=k-j+1;
            } else {
                // prevent test case like [0, 0] when there is no valid interval
                if(k-1==i) {
                    continue;
                }
                sum+=k-j;
            }

        }

        return sum;
    }
}
