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


    @Test
    public void testJumpGameGreedy() {
        JumpGameTwo jumpGameTwo = new JumpGameTwo();
        int result = jumpGameTwo.jumpGreedy(new int[]{3,2,1,1,0,0,4});
        assertEquals(Integer.MAX_VALUE, result);
    }
}
