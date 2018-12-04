package amazon;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumClosestTest {

    @Test
    public void test() {
        TwoSumClosest twoSumClosest = new TwoSumClosest();

        List<List<Integer>> list1 = new ArrayList<>();
        list1.add(Arrays.asList(1, 3000));
        list1.add(Arrays.asList(2, 5000));
        list1.add(Arrays.asList(3, 7000));
        list1.add(Arrays.asList(4, 10000));

        List<List<Integer>> list2 = new ArrayList<>();
        list2.add(Arrays.asList(1, 2000));
        list2.add(Arrays.asList(2, 3000));
        list2.add(Arrays.asList(3, 4000));
        list2.add(Arrays.asList(4, 5000));


        System.out.println(twoSumClosest.getMaxPair(list1, list2, 10000));




    }
}
