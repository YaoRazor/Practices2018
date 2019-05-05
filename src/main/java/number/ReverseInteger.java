package number;

public class ReverseInteger {
    public int reverse(int x) {
        long ans = 0;
        while(x!=0) {
            ans = ans*10;
            ans += x%10;
            x = x/10;
        }

        if(ans>(long)Integer.MAX_VALUE || ans<(long)Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int)ans;
        }
    }

}
