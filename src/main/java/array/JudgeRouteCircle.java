package array;

import java.util.HashMap;
import java.util.Map;

public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {

        int vertical = 0;
        int horizontal = 0;

        for(int i=0; i<moves.length(); i++) {

            if('U' == moves.charAt(i)) {
                vertical++;
            }
            if('D' == moves.charAt(i)) {
                vertical--;
            }
            if('L' == moves.charAt(i)) {
                horizontal--;
            }
            if('R' == moves.charAt(i)) {
                horizontal++;
            }

        }

        if(vertical==0 && horizontal==0) {
            return true;
        } else {
            return false;
        }

    }
}
