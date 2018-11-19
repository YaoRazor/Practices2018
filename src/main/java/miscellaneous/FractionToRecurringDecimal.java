package miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

    // 这是一道纯实现题，一般来说，对于数值处理类问题，要注意两点
    // 一是正负号，二是overflow
    public String fractionToDecimal(int numerator, int denominator) {

        // Edge case handling
        if(numerator==0) {
            return "0";
        }

        if(denominator==0) {
            throw new RuntimeException();
        }

        // Handle overflow
        long numeratorL = (long)numerator;
        long denominatorL = (long)denominator;
        String symbol = "";

        // Positive or negative
        if(numeratorL*denominatorL<0) {
            symbol = "-";
        }

        numeratorL = Math.abs(numeratorL);
        denominatorL = Math.abs(denominatorL);

        StringBuilder sb = new StringBuilder();
        sb.append(symbol);

        // Handle the digits before zero
        long numberBeforeZero = numeratorL/denominatorL;
        sb.append(numberBeforeZero);

        numeratorL = numeratorL%denominatorL;

        if(numeratorL==0) {
            return sb.toString();
        }

        Map<Long, Integer> map = new HashMap<>();

        sb.append(".");

        // handle the digits after zero
        while (numeratorL>0) {

            // 记录第一次出现该余数的时候，因为有可能出现5.(123)这种情况，所以
            // 不能只是简单的把上一位的结果加正负号，需要一个map来记录第一次出现
            // 这个余数的情况
            if(map.containsKey(numeratorL)) {
                sb.insert((int)map.get(numeratorL), '(');
                sb.append(')');
                break;
            }

            map.put(numeratorL, sb.length());

            numeratorL*=10;
            long newDigit = numeratorL/denominatorL;

            sb.append(newDigit);

            numeratorL%=denominatorL;

        }

        return sb.toString();

    }
}
