package airbnb;

import org.junit.Test;


import static junit.framework.TestCase.assertTrue;

public class SlidingPuzzleTest {


    @Test
    public void test() {

        int[][] matrix = {
                {3, 1, 4},
                {6, 2, 0},
                {7, 5, 8}
        };
        SlidingPuzzle sol = new SlidingPuzzle();
        assertTrue(sol.slidingPuzzle(matrix));
//        List<String> res = sol.getSolution();
//        System.out.println(res);
//        assertEquals(11, (int) res.size());
//        assertEquals("Left", res.get(0));
//        assertEquals("Down", res.get(1));
//        assertEquals("Left", res.get(2));
//        assertEquals("Up", res.get(3));
//        assertEquals("Up", res.get(4));
//        assertEquals("Right", res.get(5));
//        assertEquals("Right", res.get(6));
//        assertEquals("Down", res.get(7));
//        assertEquals("Left", res.get(8));
//        assertEquals("Up", res.get(9));

        SlidingPuzzle slidingPuzzle = new SlidingPuzzle();



    }
}
