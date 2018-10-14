package dp;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestJumpGameTwo {


    @Test
    public void testJumpGameTwo() {

        JumpGameTwo jumpGameTwo = new JumpGameTwo();


        int result = jumpGameTwo.jump(new int[]{8,3,1,1, 3});

        assertEquals(1, result);

    }

}
