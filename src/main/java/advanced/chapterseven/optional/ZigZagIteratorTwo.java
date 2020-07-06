package advanced.chapterseven.optional;

import java.util.Iterator;
import java.util.List;

public class ZigZagIteratorTwo {

    int k = 0;
    int n = 0;
    int cur = 0;
    Iterator[] arrayOfIterator;
    boolean[] isEmpty;

    public ZigZagIteratorTwo(List<List<Integer>> vecs) {
        k = vecs.size();
        cur = -1;
        arrayOfIterator = new Iterator[k];
        isEmpty = new boolean[k];
        for(int i=0; i<k; i++) {
            arrayOfIterator[i] = vecs.get(i).iterator();
        }
    }

    /*
     * @return: An integer
     */
    public int next() {
        int tmp = (int)arrayOfIterator[cur].next();
        // System.out.println("cur is "+cur+" tmp is "+tmp);
        return tmp;
    }

    private void getNextElement() {
        cur = (cur+1)%k;

        for(int i=0; i<k; i++) {
            if(arrayOfIterator[cur].hasNext()) {
                return;
            } else {
                if(!isEmpty[cur]) {
                    isEmpty[cur] = true;
                    n++;
                }
                cur = (cur+1)%k;
            }
        }
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        getNextElement();
        return n!=k;
    }
}
