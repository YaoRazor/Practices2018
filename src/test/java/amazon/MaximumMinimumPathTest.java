package amazon;

import org.junit.Test;

public class MaximumMinimumPathTest {


    @Test
    public void test() {
        MaximumMinimumPath maximumMinimumPath = new MaximumMinimumPath();

        int[][] test = new int[][] {
                {8, 4, 7},
                {6, 5, 9},
                {6, 6, 7}
        };

        System.out.println(maximumMinimumPath.maximumMinimumPath(test));

    }
}
