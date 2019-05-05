package miscellaneous;

import java.util.Arrays;

public class CountPrime {

    public int countPrimes(int n) {

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int ans = 0;

        for(int i=2; i<n; i++) {

            if(isPrime[i]) {

                ans++;

                for(int j=2; i*j<n; j++) {
                    isPrime[i*j] = false;
                }
            }

        }

        return ans;
    }
}
