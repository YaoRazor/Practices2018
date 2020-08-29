package matrix;

import org.junit.Test;

public class TestDiagonalTraverse {


    @Test
    public void test() {

        DiagonalTraverse diagonalTraverse = new DiagonalTraverse();

        int[][] test = new int[][] {
                {2, 3},
        };

        diagonalTraverse.findDiagonalOrder(test);

    }
}
