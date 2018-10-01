package array;

import org.junit.Test;
import slidingwindow.MinimumWindowSubstring;

public class TestMinimumWindowSubstring {

//    "ADOBECODEBANC"
//            "ABC"

    @Test
    public void test() {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();

        minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC");

    }
}
