package heap;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> flatternedList = new ArrayList<>();
        schedule.forEach(flatternedList::addAll);

        List<Interval> merged = merge(flatternedList);

        int preEnd = merged.get(0).end;

        List<Interval> ans = new ArrayList<>();

        for(int i=1; i<merged.size(); i++) {
            Interval freeTime = new Interval(preEnd, merged.get(i).start);
            ans.add(freeTime);
            preEnd = merged.get(i).end;
        }

        return ans;

    }

    private List<Interval> merge(List<Interval> intervals) {
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

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
}
