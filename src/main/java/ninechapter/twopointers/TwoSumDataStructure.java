package ninechapter.twopointers;

import java.util.HashMap;
import java.util.Map;


public class TwoSumDataStructure {

    Map<Integer, Integer> map = new HashMap<>();

    public void add(int number) {
        map.put(number,map.getOrDefault(number, 0)+1);
        // write your code here
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for(Integer cur: map.keySet()) {
            Integer theOther = value-cur;

            if(cur!=theOther && map.containsKey(theOther)) {
                return true;
            }

            if(cur==theOther && map.get(cur)>=2) {
                return true;
            }
        }

        return false;
    }
}

