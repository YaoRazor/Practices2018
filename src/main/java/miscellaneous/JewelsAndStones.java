package miscellaneous;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yawang on 4/15/18.
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {

        Set<Character> setOfJewels = new HashSet<>();

        for(int i=0; i<J.length(); i++) {
            setOfJewels.add( J.charAt(i));
        }

        int count = 0;
        for(int i=0; i<S.length(); i++) {

            if(setOfJewels.contains(S.charAt(i))) {
                count++;
            }
        }

        return count;

    }
}
