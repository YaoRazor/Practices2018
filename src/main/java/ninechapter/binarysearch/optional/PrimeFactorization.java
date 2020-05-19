package ninechapter.binarysearch.optional;

import java.util.ArrayList;
import java.util.List;

// Pure math problem, avoid this problem in second round
public class PrimeFactorization {
    public List<Integer> primeFactorization(int num) {
        List<Integer> ans = new ArrayList<>();

        for(int i=2; i*i<=num; i++) {
            while(num%i==0) {
                num = num/i;
                ans.add(i);
            }
        }

        if(num!=1) {
            ans.add(num);
        }

        return ans;
    }
}
