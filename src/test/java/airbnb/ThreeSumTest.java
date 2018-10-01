package airbnb;

import org.junit.Test;

public class ThreeSumTest {


    @Test
    public void test() {

        ThreeSum threeSum = new ThreeSum();

        int[] array = new int[] {-1, 0, 1, 2, -1, -4};

        threeSum.threeSum(array);
    }
}
