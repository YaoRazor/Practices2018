package ninechapter.hash_and_heap.optional;

import java.util.*;

public class Flatten2DVector {

    Iterator<List<Integer>> row;
    Iterator<Integer> col;

    public Flatten2DVector(List<List<Integer>> vec2d) {
        row = vec2d.iterator();
    }

    private void iteratorRow() {
        while(row.hasNext()) {
            col = row.next().iterator();
            if(col.hasNext()) {
                break;
            }
        }
    }

    public Integer next() {
        return col.next();
    }

    public boolean hasNext() {
        if(col==null || !col.hasNext()) {
            iteratorRow();
        }

        if(col!=null && col.hasNext()) {
            return true;
        } else {
            return false;
        }
        // Write your code here
    }
}
