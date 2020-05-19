package ninechapter.hash_and_heap.optional;

import java.util.*;

public class HighFive {

    class Record {
       public int id, score;
       public Record(int id, int score){
           this.id = id;
           this.score = score;
       }
    }

    public Map<Integer, Double> highFive(Record[] results) {

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();;

        for(Record record: results) {
            int id = record.id;
            PriorityQueue<Integer> pq;
            if(map.containsKey(id)) {
                pq = map.get(id);
            } else {
                pq = new PriorityQueue<>();
                map.put(id, pq);
            }

            pq.add(record.score);
            if(pq.size()>5) {
                pq.poll();
            }
        }

        Map<Integer, Double> ans = new HashMap<>();
        for(Integer id: map.keySet()) {

            PriorityQueue pq = map.get(id);
            int total = 0;

            while(!pq.isEmpty()) {
                total= total + (int)pq.poll();
            }

            ans.put(id, (double)total/5);

        }

        return ans;
    }
}
