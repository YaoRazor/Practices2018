package ninechapter.hash_and_heap.optional;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueNumberInDataStream {
    public int firstUniqueNumber(int[] nums, int number) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isFound = false;

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
            if(num==number) {
                isFound = true;
                break;
            }
        }

        if(!isFound) {
            return -1;
        }

        for(int num: nums) {
            if(map.get(num)==1) {
                return num;
            }
        }

        return -1;
    }
}
