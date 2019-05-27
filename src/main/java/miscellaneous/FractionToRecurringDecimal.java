package miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

    // 这是一道纯实现题，一般来说，对于数值处理类问题，要注意两点
    // 一是正负号，二是overflow
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();

        long numeratorL = (long)numerator;
        long denominatorL = (long)denominator;

        if(numeratorL*denominatorL<0) {
            sb.append("-");
        }

        numeratorL = Math.abs(numeratorL);
        denominatorL = Math.abs(denominatorL);

        sb.append(numeratorL/denominatorL);
        numeratorL=numeratorL%denominatorL;

        // The calculation before dot and calculation after dot is not the same
        if(numeratorL!=0) {
            sb.append(".");
        } else {
            return sb.toString();
        }

        Map<Long, Integer> position = new HashMap<>();

        // handle the digits after zero
        while (numeratorL>0) {
            // 记录第一次出现该余数的时候，因为有可能出现5.(113)这种情况，所以并不是对于
            // 余数来记录位置，而是对于被除数来记录上一次出现的位置，如果被除数出现以前出现过的
            // 结果，那么说明有环
            if(position.containsKey(numeratorL)) {
                sb.insert((int)position.get(numeratorL), '(');
                sb.append(')');
                break;
            }

            position.put(numeratorL, sb.length());

            numeratorL*=10;
            long cur = numeratorL/denominatorL;
            sb.append(cur);
            numeratorL%=denominatorL;
        }

        return sb.toString();
    }
}
