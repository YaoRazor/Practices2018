package airbnb;

public class ConsecutiveNumbersSum {

    // Brute-force
    public int consecutiveNumbersSumBruteForce(int N) {

        int ans = 0;

        for(int i = 1; i<=N; i++) {

            int target =N, start =i;

            while (target>0) {

                target-=start;
                start++;


            }

            if(target==0) {
                ans++;
            }


        }

        return ans;

    }


    public int consecutiveNumbersSum(int N) {

        int ans = 0;

        for(int k = 1; (k-1)*k<2*N; k++) {

            if((2*N - (k-1)*k) %(2*k) ==0) {
                ans++;
            }

        }

        return ans;

    }



}
