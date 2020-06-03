package advanced.chapterfour;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfAirplanesIntheSky {

    class Interval {
         int start, end;
         Interval(int start, int end) {
             this.start = start;
             this.end = end;
         }
     }

    class Event {
        int index;
        int type;

        Event(int index, int type) {
            this.index = index;
            this.type = type;
        }
    }

    class EventComparator implements Comparator<Event> {

        @Override
        public int compare(Event e1, Event e2) {
            if(e1.index==e2.index) {
                return e1.type-e2.type;
            } else {
                return e1.index-e2.index;
            }
        }

    }


    public int countOfAirplanes(List<Interval> airplanes) {
        PriorityQueue<Event> pq = new PriorityQueue<>(new EventComparator());
        int cnt = 0;
        int ans = 0;

        for(Interval interval: airplanes) {
            pq.offer(new Event(interval.start, 1));
            pq.offer(new Event(interval.end, -1));
        }

        while(pq.size()>0) {
            Event cur = pq.poll();

            if(cur.type==1) {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                cnt--;
            }
        }

        return ans;
    }
}
