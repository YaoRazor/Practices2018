package airbnb;

import java.util.Iterator;
import java.util.List;

public class TwoDIteratorWithRemove implements Iterator<Integer> {

    Iterator<List<Integer>> rowIterator;
    Iterator<Integer> colIterator;

    public TwoDIteratorWithRemove(List<List<Integer>> original) {
        rowIterator = original.iterator();
        colIterator = null;
    }

    @Override
    public boolean hasNext() {

        while (colIterator==null || !colIterator.hasNext() && rowIterator.hasNext()) {
            colIterator = rowIterator.next().iterator();
        }

        return colIterator!=null && colIterator.hasNext();
    }

    @Override
    public Integer next() {

        if(!hasNext()) {
            return null;
        }
        return colIterator.next();
    }

    @Override
    public void remove() {

        while (colIterator==null  && rowIterator.hasNext()) {
            colIterator = rowIterator.next().iterator();
        }

        if(colIterator!=null) {
            colIterator.remove();
        }

    }
}
