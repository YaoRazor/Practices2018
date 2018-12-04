import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class MergeInterval {
    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> ans = new ArrayList<>();

        if(intervals==null || intervals.size()==0) {
            return ans;
        }

        intervals.sort(Comparator.comparingInt(a -> a.start));

        Interval pre = intervals.get(0);

        for(int i=1; i<intervals.size(); i++) {
            Interval cur = intervals.get(i);

            if(pre.end<cur.start) {
                ans.add(pre);
                pre = cur;
            } else {
                pre.end = Math.max(pre.end, cur.end);
            }

        }

        ans.add(pre);
        return ans;
    }


}

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}





