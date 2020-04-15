import org.junit.Test;

public class RandomTest {


    @Test
    public void testTestSearchInRotatedSortedArray() {

//        System.out.println(Integer.valueOf("00"));

        System.out.println(gcd(0, 2));

        return;
    }


    public int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }

}
