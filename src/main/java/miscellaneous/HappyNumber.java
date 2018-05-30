package miscellaneous;

//要点是其实最终是有环的
public class HappyNumber {

    public boolean isHappy(int n) {
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
