package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yawang on 3/11/18.
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

}

public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {

        if(intervals == null || intervals.length <= 1) {
            return true;
        }

        List<Interval> intervalList = Arrays.asList(intervals);

        Collections.sort(intervalList, Comparator.comparingInt(o -> o.start));

        for(int i=1; i<intervals.length; i++) {

            if(intervals[i].start<intervals[i-1].end) {
                return false;
            }

        }

        return true;
    }
}
