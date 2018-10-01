package array;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();
        int size = tasks.length;

        for(char task: tasks) {
            if(map.containsKey(task)) {
                map.put(task, map.get(task)+1);
            } else {
                map.put(task, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y)->(y-x));

        for(Character key: map.keySet()) {
            pq.offer(map.get(key));
        }

        int ans = 0;

        while (pq.size()>0) {

            List<Integer> tmp = new ArrayList<>();
            int i = 0;

            while (pq.size()>0 && i<=n) {

                Integer cur = pq.poll();
                if(cur>1) {
                    tmp.add(cur-1);
                }

                i++;
            }

            if(tmp.size()>0) {
                ans+=n+1;
            } else {
                ans+=i;
            }


            pq.addAll(tmp);

        }


        return ans;

    }


    public int leastIntervalTwo(char[] tasks, int n) {

        int[] map = new int[26];

        for(char c: tasks) {

            map[c-'A']++;
        }
        Arrays.sort(map);

        int idol = (map[25]-1)*n;

        for(int i =24; i>=0 && map[i]>0; i--) {

            idol-= Math.min(map[i], map[25]-1);
        }


        return idol>0? idol+tasks.length: tasks.length;

    }
}
