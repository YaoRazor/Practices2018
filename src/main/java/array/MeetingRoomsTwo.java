package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yawang on 3/12/18.
 */
public class MeetingRoomsTwo {

        public int minMeetingRooms(Interval[] intervals) {
            if(intervals == null || intervals.length <= 1) {
                return 1;
            }

            List<Interval> intervalList = Arrays.asList(intervals);

            Collections.sort(intervalList, Comparator.comparingInt(o -> o.end));

            int cur = 1;

            for(int i=1; i<intervals.length; i++) {
                cur--;
                if(intervals[i].start < intervals[i-1].end) {
                    cur++;
                }
            }

            return cur+1;
        }

}
