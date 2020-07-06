package advanced.chapterfour.optional;

import datastructures.Interval;

import java.util.*;

// nlogn
public class TimeInterSection {

    class Event {
        int time;
        int type;   //-1 means start, 1 means end
        Event(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }

    class EventComparator implements Comparator<Event> {

        @Override
        public int compare(Event e1, Event e2) {
            if(e1.time==e2.time) {
                return e1.type-e2.type;
            } else {
                return e1.time-e2.time;
            }
        }

    }

    public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        List<Interval> ans = new ArrayList<>();
        if(seqA==null || seqA.size()==0 || seqB==null || seqB.size()==0) {
            return ans;
        }

        PriorityQueue<Event> pq = new PriorityQueue<>(new EventComparator());

        int preStart = -1;

        for(Interval tmp : seqA) {
            pq.offer(new Event(tmp.start, -1));
            pq.offer(new Event(tmp.end, 1));
        }

        for(Interval tmp : seqB) {
            pq.offer(new Event(tmp.start, -1));
            pq.offer(new Event(tmp.end, 1));
        }

        int available = 0;

        while(pq.size()>0) {
            Event event = pq.poll();
            if(event.type==-1) {
                available++;
                if(available==2) {
                    preStart = event.time;
                }
            } else {
                available--;
                if(available==1) {
                    ans.add(new Interval(preStart, event.time));
                }
            }
        }

        return ans;
    }
}
