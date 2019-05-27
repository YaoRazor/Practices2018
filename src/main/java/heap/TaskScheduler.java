package heap;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        Arrays.sort(tasks);
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<tasks.length; i++) {
            char cur = tasks[i];
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }

        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> e2.count-e1.count);

        for(Character key: map.keySet()) {
            pq.offer(new Element(key, map.get(key)));
        }

        int ans = 0;
        int count = n+1;

        while(!pq.isEmpty()) {

            Queue<Element> queue = new ArrayDeque<>();

            while(pq.size()>0 && count>0) {
                Element cur = pq.poll();
//                System.out.println("Put "+ cur.val+ " in\n");
                cur.count--;
                if(cur.count!=0) {
                    queue.offer(cur);
                }
                count--;
            }

            if(queue.size()>0) {
                ans+=n+1;
            } else {
                ans+=n+1-count;
            }

            count = n+1;

            pq.addAll(queue);
        }

        return ans;
    }



    class Element {

        public char val;
        public int count;

        public Element(char val, int count) {
            this.val = val;
            this.count = count;
        }

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
