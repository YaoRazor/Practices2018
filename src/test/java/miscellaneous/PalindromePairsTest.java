package miscellaneous;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PalindromePairsTest {


    @Test
    public void test() {

        String[] test = {"abcd","dcba","lls","s","sssll"};

        Map<String, Integer> map = new HashMap<>();


        for(int i=0; i<test.length; i++) {
            map.put(new StringBuilder(test[i]).reverse().toString(), i);
        }

        Integer i = map.get("bcd");

        PalindromePairs palindromePairs = new PalindromePairs();


        palindromePairs.palindromePairs(test);



    }




}
