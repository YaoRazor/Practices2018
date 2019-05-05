package airbnb;

import org.junit.Test;

public class PourOfWaterTest {



    @Test
    public void test() {


    PourOfWater pw = new PourOfWater();
    int[] heights = {5,4,2,1,2,3,2,1,0,1,2,4};
    for (int i = 1; i <= 9; i++) {
      pw.pourWater(heights, i, 5);
    }
    }


}
