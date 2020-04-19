package ninechapter.hash_and_heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumberTwo {
    public int nthUglyNumber(int n) {
        Set<Long> seen = new HashSet<>();

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1l);

        long[] primes = new long[]{2l, 3l, 5l};
        int i=1;
        long ret = 0;

        while(!pq.isEmpty()) {
            long cur = pq.poll();
            if(i==n) {
                ret = cur;
                break;
            }

            for(int j=0; j<3; j++) {
                long tmp = primes[j]*cur;
                if(seen.contains(tmp)) {
                    continue;
                }
                seen.add(tmp);
                pq.offer(tmp);
            }
            i++;
        }

        return (int)ret;
    }
}
