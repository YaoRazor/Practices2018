package miscellaneous;

import java.util.HashSet;
import java.util.Set;

//要点是其实最终是有环的
public class HappyNumber {

    public boolean isHappySpaceEfficient(int n) {
        if(n<=0) {
            return false;
        }

        int slow = n;
        int fast = n;
        do {
            slow = getSquareSum(slow);
            fast = getSquareSum(fast);
            fast = getSquareSum(fast);
        } while(slow!=fast);

        if(fast == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isHappyTimeEfficient(int n) {

        Set<Integer> seen = new HashSet<>();
        int cur = n;

        do {
            seen.add(cur);
            cur = getSquareSum(cur);
        } while(!seen.contains(cur));

        if(cur == 1) {
            return true;
        } else {
            return false;
        }

    }


    private int getSquareSum(int n) {

        int sum = 0;
        while(n>0) {
            int cur = n%10;
            sum+=cur*cur;
            n/=10;
        }

        return sum;
    }
}
