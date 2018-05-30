package bitmanupulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by yawang on 4/28/18.
 */
public class TestReverseBits {

    @Test
    public void test() {
        assertEquals( "10000000000000000000000000000000",
                      Integer.toBinaryString(new ReverseBits().reverseBits(1)));
    }
}
