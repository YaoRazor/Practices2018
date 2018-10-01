package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    // This is O(nlogn)
    public String frequencySort(String s) {

        StringBuilder sb = new StringBuilder();

        if(s==null || s.length()==0) {
            return sb.toString();
        }

        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        while (i<s.length()) {
            Character cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }


        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue()-o1.getValue());
        pq.addAll(map.entrySet());


        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> cur = pq.poll();

            int j = 0;

            while (j<cur.getValue()) {
                sb.append(cur.getKey());

            }
        }

        return sb.toString();

    }


    // This is O(n)
    public String frequencySortUsingBucketSort(String s) {
        StringBuilder sb = new StringBuilder();
        if(s==null || s.length()==0) {
            return sb.toString();
        }

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            Character cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur,0)+1);
        }

        List<Character>[] bucket = new List[s.length()+1];

        for(Character c: map.keySet()) {
            int frequency = map.get(c);

            if(bucket[frequency]==null) {
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(c);
        }

        for(int i=bucket.length-1; i>=0; i--) {

            if(bucket[i]!=null) {
                for(Character c: bucket[i]) {
                    int j = i;
                    while(j>0) {
                        sb.append(c);
                        j--;
                    }
                }
            }
        }

        return sb.toString();
    }
}
