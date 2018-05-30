package datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yawang on 4/29/18.
 */
public class TwoSumThree {

    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSumThree() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0)+1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {

        for(int i: map.keySet()) {
            if((value-i)==i) {
                if(map.get(i)>=2) {
                    return true;
                }
            } else if(map.containsKey(value-i)) {
                return true;
            }

        }

        return false;
    }
}

