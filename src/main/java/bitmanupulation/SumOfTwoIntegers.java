package bitmanupulation;


// This is just an algorithm, see
// https://en.wikipedia.org/wiki/Adder_%28electronics%29#Half_adder
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while(b!=0) {
            int carry = a&b;
            a = a^b;
            b = carry<<1;
        }

        return a;
    }
}
