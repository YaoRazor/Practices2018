package array;

import java.util.*;


public class MeetingRoomsTwo {

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
