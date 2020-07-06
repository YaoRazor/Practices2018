package ninechapter.hash_and_heap.optional;

import java.util.*;

public class Flatten2DVector implements Iterator<Integer> {

    Iterator<List<Integer>> i1;
    Iterator<Integer> i2;

    public Flatten2DVector(List<List<Integer>> vec2d) {
        i1 = vec2d.iterator();
        // Initialize your data structure here
    }

    @Override
    public Integer next() {
        return i2.next();
    }

    private void getNextElement() {
        if(i2==null || !i2.hasNext()) {
            while(i1.hasNext()) {
                i2 = i1.next().iterator();
                if(i2.hasNext()) {
                    break;
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        getNextElement();
        return i2!=null && i2.hasNext();
    }

    @Override
    public void remove() {}
}
