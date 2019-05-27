package design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class InsertDeleteGetRandom {
    HashMap<Integer, Integer> map = new HashMap<>();
    LinkedList<Integer> list = new LinkedList<>();

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        } else {
            int size = list.size();
            map.put(val, size);
            list.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);

        if(index!=list.size()-1) {
            int lastElement = list.get(list.size()-1);
            map.put(lastElement, index);
            list.set(index, lastElement);
        }

        list.removeLast();
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();

        int index = random.nextInt(list.size());
        return list.get(index);

    }
}
