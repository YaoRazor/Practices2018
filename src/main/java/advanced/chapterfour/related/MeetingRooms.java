package advanced.chapterfour.related;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

// TC: O(nlogn)
public class MeetingRooms {

    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) {
            return true;
        }

        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));

        for(int i=1; i<intervals.size(); i++) {
            if(intervals.get(i).start<intervals.get(i-1).end) {
                return false;
            }
        }

        return true;
    }
}
