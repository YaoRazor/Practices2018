package airbnb;

import java.util.Iterator;
import java.util.List;

public class Flatten2DVectorWithRemove implements Iterator<Integer> {
    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Flatten2DVectorWithRemove(List<List<Integer>> vec2d) {
        this.i = vec2d.iterator();
        this.j = null;
    }

    @Override
    public boolean hasNext() {

        while((j==null || !j.hasNext()) && i.hasNext()) {
            j = i.next().iterator();
        }


        return j!=null && j.hasNext();
    }

    @Override
    public Integer next() {
        if(!j.hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        return j.next();
    }

    @Override
    public void remove() {

        while (j == null && i.hasNext()) {
            j  = i.next().iterator();
        }
        if (j != null) {
            j.remove();
        }

    }
}
