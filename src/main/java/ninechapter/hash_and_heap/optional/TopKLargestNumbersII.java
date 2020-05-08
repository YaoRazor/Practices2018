package ninechapter.hash_and_heap.optional;

import java.util.*;

public class TopKLargestNumbersII {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    private int k;
    /*
     * @param k: An integer
     */public TopKLargestNumbersII(int k) {
        this.k = k;
        // do intialization if necessary
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        pq.offer(num);

        if(pq.size()>k) {
            pq.poll();
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        Iterator<Integer> it = pq.iterator();

        LinkedList<Integer> ans = new LinkedList<>();
        while(it.hasNext()) {
            ans.addFirst(it.next());
        }

        Collections.sort(ans, Collections.reverseOrder());
        return ans;
    }

}
