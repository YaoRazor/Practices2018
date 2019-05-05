package airbnb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class MeetingTime {


    public List<Interval> getAvailableIntervals(List<List<Interval>> intervals, int k) {

        List<Interval> ans = new ArrayList<>();
        if(intervals==null || intervals.size()==0) {
            return ans;
        }


        List<Point> points = new ArrayList<>();


        for(List<Interval> list: intervals) {

            for(Interval interval: list) {
                points.add(new Point(interval.start, 1));
                points.add(new Point(interval.end, 0));
            }

        }

        Collections.sort(points, (a, b) -> {

            if(a.time==b.time) {
                return a.type-b.type;
            } else {
                return a.time-b.time;
            }

        });

        int total = intervals.size();

        Integer curStart = null;
        int cnt = 0;

        for(int i=0; i<points.size(); i++) {

            Point cur = points.get(i);

            if(cur.type==1) {
                cnt++;

                if(i==0 && cnt<=total-k) {
                    curStart = cur.time;
                } else if(curStart!=null && cnt==total-k+1) {
                    // Normal workflow
                    if(cur.time!=curStart) {
                        ans.add(new Interval(curStart, cur.time));
                    }
                    curStart = null;
                }

            } else {
                cnt--;
                if(cnt==total-k && i<points.size()-1) {
                    // Normal workflow
                    curStart = cur.time;
                } else if(i==points.size()-1 && cnt<=total-k-1) { //这里cnt要小于等于total-k-1，这样才能保证之前有start
                    ans.add(new Interval(curStart, cur.time));
                    curStart = null;

                }

            }

        }

        return ans;
    }



    class Point {

        int time;

        int type; //end is 0, start is 1;

        public Point(int time, int type) {
            this.time = time;
            this.type = type;

        }
    }


}

//public class MeetingTime {
//    public  List<Interval> getAvailableIntervals(List<List<Interval>> intervals, int k) {
//        List<Interval> res = new ArrayList<>();
//        List<Point> points = new ArrayList<>();
//        for (List<Interval> intervalList : intervals) {
//            for (Interval interval : intervalList) {
//                points.add(new Point(interval.start, true));
//                points.add(new Point(interval.end, false));
//            }
//        }
//        Collections.sort(points);
//
//        int count = 0;
//        Integer availableStart = null;
//        for (int i = 0; i < points.size(); i++) {
//            Point point = points.get(i);
//            if (point.isStart) {
//                count++;
//                if (availableStart == null && i == 0 && count <= intervals.size() - k) {
//                    availableStart = point.time;
//                } else if (availableStart != null && count == intervals.size() - k + 1) {
//                    res.add(new Interval(availableStart, point.time));
//                    availableStart = null;
//                }
//            } else {
//                count--;
//                if (count == intervals.size() - k && i < points.size() - 1) {
//                    availableStart = point.time;
//                } else if (availableStart != null && i == points.size() - 1 && count <= intervals.size() - k) {
//                    res.add(new Interval(availableStart, point.time));
//                    availableStart = null;
//                }
//            }
//        }
//
//        return res;
//    }
//}
//
//class Interval {
//    int start;
//    int end;
//    Interval(int s, int e) {
//        start = s;
//        end = e;
//    }
//}
//
//class Point implements Comparable<Point> {
//    int time;
//    boolean isStart;
//    Point(int time, boolean isStart) {
//        this.time = time;
//        this.isStart = isStart;
//    }
//    @Override
//    public int compareTo(Point that) {
//        if (this.time != that.time || this.isStart == that.isStart) {
//            return this.time - that.time;
//        } else {
//            return this.isStart ? -1 : 1;
//        }
//    }
//}
