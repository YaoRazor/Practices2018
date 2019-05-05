package airbnb;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一组meetings(每个meeting由start和end时间组成)。求出在所有输入meeting时间段内没有会议，也就是空闲的时间段.
 * 每个subarray都已经sort好。N个员工，每个员工有若干个interval表示在这段时间是忙碌的。求所有员工都不忙的intervals。
 * For example:
 * [
 *  [[1, 3], [6, 7]],
 *  [[2, 4]],
 *  [[2, 5], [9, 12]]
 * ]
 * Output
 * [[4, 6], [7, 9]]
 *
 * follow up:
 * 求不少于k个员工空闲的时间段（改一下check count的条件就可以了）
 */

public class MeetingTimeTest {




    @Test
    public void test() {

        MeetingTime meetingTime = new MeetingTime();

        List<List<Interval>> intervals = new ArrayList<>();
        List<Interval> inter1 = new ArrayList<>();
        inter1.add(new Interval(1, 3));
        inter1.add(new Interval(6, 7));
        List<Interval> inter2 = new ArrayList<>();
//        inter2.add(new Interval(2, 4));
        inter2.add(new Interval(1, 4));
        List<Interval> inter3 = new ArrayList<>();
        inter3.add(new Interval(2, 5));
        inter3.add(new Interval(9, 12));
        intervals.add(inter1);
        intervals.add(inter2);
        intervals.add(inter3);


//        List<Interval> inter4 = new ArrayList<>();
//        inter4.add(new Interval(1, 2));
//        inter3.add(new Interval(9, 12));
//        intervals.add(inter4);

        List<Interval> res = meetingTime.getAvailableIntervals(intervals, 2);
        for (Interval inter : res) {
            System.out.println("[" + inter.start + "," + inter.end + "]");
        }

        System.out.println("----------------------");

        List<Interval> res2 = meetingTime.getAvailableIntervals(intervals, 3);
        for (Interval inter : res2) {
            System.out.println("[" + inter.start + "," + inter.end + "]");
        }




    }
}
