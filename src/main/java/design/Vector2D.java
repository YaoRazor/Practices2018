package design;

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {

    Iterator<List<Integer>> outSideIterator;
    Iterator<Integer> innerIterator;

    public Vector2D(List<List<Integer>> vec2d) {

        outSideIterator = vec2d.iterator();

        if(outSideIterator.hasNext()) {
            List<Integer> innerList = outSideIterator.next();
            innerIterator = innerList.iterator();
        }

    }


    @Override
    public boolean hasNext() {

        if(innerIterator.hasNext()) {
            return true;
        } else {
            while (outSideIterator.hasNext()) {
                List<Integer> cur = outSideIterator.next();

                innerIterator = cur.iterator();

                if(innerIterator.hasNext()) {
                    return true;
                } else {
                    continue;
                }


            }
        }

        return false;
    }

    @Override
    public Integer next() {
        return innerIterator.next();
    }
}
