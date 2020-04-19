package ninechapter.hash_and_heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    Random rand = new Random();

    public InsertDeleteGetRandom() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }

        int size = map.size();

        list.add(val);
        map.put(val, size);
        return true;
        // write your code here
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        map.remove(val);

        // Only switch the item when it is not the last one
        if(index!=list.size()-1) {
            int tailValue = list.get(list.size()-1);
            list.set(index, tailValue);
            map.put(tailValue, index);
        }

        list.remove(list.size()-1);

        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        int size = list.size();
        int index = rand.nextInt(size);
        return list.get(index);
    }
}
