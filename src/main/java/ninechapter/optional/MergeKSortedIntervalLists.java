package ninechapter.optional;

import java.util.Comparator;

import java.util.*;

public class MergeKSortedIntervalLists {

    class Position {
        public int row;
        public int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }

    /**
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        List<Interval> ans = new ArrayList<>();

        // If we use Position directly in the priority queue, then we don't need this hashmap
        Map<Interval, Position> map = new HashMap<>();

        PriorityQueue<Interval> pq = new PriorityQueue<>(new IntervalComparator());

        for(int i=0; i<intervals.size(); i++) {
            List<Interval> list = intervals.get(i);
            if(list==null || list.isEmpty()) {
                continue;
            }

            Interval cur = list.get(0);
            pq.offer(cur);
            map.put(cur, new Position(i, 0));
        }

        Interval pre = null;

        while(!pq.isEmpty()) {
            Interval cur = pq.poll();
            getNextInterval(pq, map, cur, intervals);

            if(pre==null) {
                pre = cur;
                continue;
            }

            if(pre.end<cur.start) {
                ans.add(pre);
                pre = cur;
            } else {
                pre.end = Math.max(cur.end, pre.end);
            }

        }

        if(ans.get(ans.size()-1).end!=pre.end) {
            ans.add(pre);
        }

        return ans;

    }

    private void getNextInterval(PriorityQueue<Interval> pq, Map<Interval, Position> map, Interval cur, List<List<Interval>> intervals) {
        Position p = map.get(cur);
        List<Interval> list = intervals.get(p.row);
        int index = p.col+1;

        if(index< list.size()) {
            Interval interval = list.get(index);
            pq.offer(interval);
            map.put(interval, new Position(p.row, index));
        }

        map.remove(cur);
    }
}
