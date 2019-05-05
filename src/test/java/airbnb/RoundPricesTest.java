package airbnb;

import org.junit.Test;

import java.util.List;

public class RoundPricesTest {


    @Test
    public void test() {
        RoundPrices roundPrices = new RoundPrices();

        double[] test = new double[] {0.7, 2.8, 4.9, 1.0, 2.0};


        List<Integer> ans = roundPrices.getNearlyArrayWithSameSum(test, 10);

        System.out.println(ans);

        return;



    }
}
