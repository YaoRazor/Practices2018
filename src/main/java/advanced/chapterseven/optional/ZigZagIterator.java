package advanced.chapterseven.optional;

import java.util.Iterator;
import java.util.List;

// O(1) for each operation
public class ZigZagIterator {
    Iterator<Integer> i1;
    Iterator<Integer> i2;
    int i;

    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        i1 = v1.iterator();
        i2 = v2.iterator();
        int i=0;
        // do intialization if necessary
    }

    /*
     * @return: An integer
     */
    public int next() {
        if(i%2==0) {
            i++;
            if(i1.hasNext()) {
                return i1.next();
            } else {
                return i2.next();
            }

        } else {
            i++;
            if(i2.hasNext()) {
                return i2.next();
            } else {
                return i1.next();
            }
        }

        // write your code here
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        return i1.hasNext() || i2.hasNext();
    }
}
