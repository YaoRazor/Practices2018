package number;

import org.junit.Test;

import miscellaneous.DivideTwoInteger;

public class DivideTwoIntegerTest {

    @Test
    public void test() {
        DivideTwoInteger divideTwoInteger = new DivideTwoInteger();
        divideTwoInteger.divide(Integer.MIN_VALUE, 1);
    }
}
