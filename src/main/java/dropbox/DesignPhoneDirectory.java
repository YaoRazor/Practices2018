package dropbox;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class DesignPhoneDirectory {
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */

    Deque<Integer> deque = new ArrayDeque<>();
    Set<Integer>   set   = new HashSet<>();

    public DesignPhoneDirectory(int maxNumbers) {

        for(int i=0; i<maxNumbers; i++) {
            deque.addLast(i);
        }

    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(deque.isEmpty()) {
            return -1;
        } else {
            int number = deque.pollFirst();
            set.add(number);
            return number;
        }
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !set.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if(!set.contains(number)) {
            return;
        }
        set.remove(number);
        deque.addLast(number);
    }
}
