package advanced.chapterfour.related;

import java.util.Arrays;

// TC: O(nlogn)
public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
         if(intervals==null || intervals.length==0) {
             return true;
         }

        Arrays.sort(intervals, (i1, i2)-> i1[0]-i2[0]);
        int last = -1;

        for(int[] interval: intervals) {
            if(interval[0]<last) {
                return false;
            }
            last = interval[1];
        }

        return true;
    }
}
