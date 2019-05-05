package airbnb;

import org.junit.Test;

public class CollatzConjectureTest {


    @Test
    public void test() {
        CollatzConjecture cc = new CollatzConjecture();

        //    // 1
//    // 2 -> 1
//    // 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
//    // 4 -> 2 -> 1
//    // 5 -> 16 -> 8 -> 4 -> 2 -> 1
//    // 6 -> 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
//    // 7 -> 22 -> 11 -> 34 -> 17 -> 52 -> 26 -> 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
//    // ...
//
    for (int i = 1; i <= 7; i++) {
      System.out.println(cc.findLongestSteps(i));
    }

//    System.out.println(cc.findLongestSteps(4));
//    System.out.println(cc.findLongestSteps(1000));

//        collatzConjecture.findLongestSteps()

    }
}
