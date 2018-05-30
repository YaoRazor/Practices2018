package miscellaneous;

import org.junit.Test;

/**
 * Created by yawang on 4/29/18.
 */
public class TestZigZagConversion {

    @Test
    public void test() {

//        int x = Integer.MIN_VALUE;

        int tmp = Integer.MIN_VALUE-1;
        int tmp2 = Integer.MAX_VALUE+1;

        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 4));

    }
}
