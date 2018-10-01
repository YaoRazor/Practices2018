package airbnb;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConsecutiveNumbersSumTest {

    @Test
    public void test() {

        ConsecutiveNumbersSum consecutiveNumbersSum = new ConsecutiveNumbersSum();

        assertEquals(3, consecutiveNumbersSum.consecutiveNumbersSum(9));

    }
}
