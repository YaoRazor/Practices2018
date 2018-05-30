import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class MergeInterval {
    public List<Interval> merge(List<Interval> intervals) {

        if(intervals == null || intervals.size() == 0) {
            return intervals;
        }

        List<Interval> sortedIntervals = intervals.stream().sorted(Comparator.comparingInt(d -> d.start))
                .collect(Collectors.toList());

        List<Interval> mergedIntervals = new LinkedList<>();

        Interval mergedInterval = sortedIntervals.get(0);

        for(int i=1; i<sortedIntervals.size(); i++) {
            Interval currentInterval = sortedIntervals.get(i);
            if(currentInterval.start <= mergedInterval.end) {
                mergedInterval.end =  Math.max(mergedInterval.end, currentInterval.end);
            } else {
                mergedIntervals.add(mergedInterval);
                mergedInterval = currentInterval;
            }

        }
        mergedIntervals.add(mergedInterval);
        return mergedIntervals;
    }

    public List<Interval> mergeTwo(List<Interval> intervals) {

        if(intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        intervals.sort(Comparator.comparingInt(d -> d.start));

        LinkedList<Interval> merged = new LinkedList<>();

        merged.add(intervals.get(0));

        for (int i = 1; i< intervals.size(); i ++) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            Interval interval = intervals.get(i);
            if ( merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }
}

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}





