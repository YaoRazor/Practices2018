package heap;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class TaskSchedulerTest {


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
                ans++;
            }

            if(queue.size()>0) {
                ans+=count;
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
}
