package number;

//http://blog.csdn.net/linhuanmars/article/details/20024837
public class ReverseInteger {
    public int reverse(int x) {
        // Handle overflow
        if(x==Integer.MIN_VALUE){
            return 0;
        }

        int num = Math.abs(x);
        int res = 0;
        while(num!=0)
        {
            if(res>(Integer.MAX_VALUE-num%10)/10) // Handle overflow
                return 0;
            res = res*10+num%10;
            num /= 10;
        }
        return x>0?res:-res;

    }

}
