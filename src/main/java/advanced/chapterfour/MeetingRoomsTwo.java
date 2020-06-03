package advanced.chapterfour;

import java.util.*;

public class MeetingRoomsTwo {
    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class MeetingEvent {
        int time;
        int eventType;  // 0 means end, 1 means start

        public MeetingEvent(int time, int eventType) {
            this.time = time;
            this.eventType = eventType;
        }
    }

    // Sweepline, Time complexity: O(nlogn)
    // This problem is exactly the same as number of airplanes in the sky
    public int minMeetingRoomsSweepingLine(Interval[] intervals) {
        if(intervals==null || intervals.length==0) {
            return 0;
        }

        PriorityQueue<MeetingEvent> pq = new PriorityQueue<>(
                (a, b) -> {
                    if(a.time==b.time) {
                        return a.eventType-b.eventType;
                    } else {
                        return a.time-b.time;
                    }
                }
        );

        for(Interval interval: intervals) {
            pq.add(new MeetingEvent(interval.start, 1));
            pq.add(new MeetingEvent(interval.end, 0));
        }

        int cnt = 0;
        int ans = 0;

        while(!pq.isEmpty()) {
            MeetingEvent event = pq.poll();

            if(event.eventType==1) {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                cnt--;
            }
        }

        return ans;
    }

    public int minMeetingRooms(Interval[] intervals) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        List<Interval> intervalList = Arrays.asList(intervals);

        Collections.sort(intervalList, Comparator.comparingInt(o -> o.start));

        int ans = 0;

        for(Interval interval: intervalList) {

                while (!queue.isEmpty()) {

                    if(queue.peek()<interval.start) {
                        queue.poll();
                    } else {
                        break;
                    }
                }

                queue.add(interval.end);

                ans = Math.max(ans, queue.size());
        }

        return ans;
    }

    public int minMeetingRoomsTwo(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int ans = 0;
        int endPointer = 0;

        for(int i=0; i<intervals.length; i++) {
            if(start[i]<end[endPointer]) {
                ans++;
            } else {
                endPointer++;
            }
        }

        return ans;
    }


}
