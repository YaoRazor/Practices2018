package ninechapter.optional;

import java.util.ArrayList;
import java.util.List;

public class MergetTwoSortedIntervalLists {

    public class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
    }

    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        if(list1==null || list1.size()==0) {
            return list2;
        }

        if(list2==null || list2.size()==0) {
            return list1;
        }

        List<Interval> ans = new ArrayList<>();

        int i = 0;
        int j = 0;
        Interval pre = list1.get(i).start<=list2.get(j).start? list1.get(i++): list2.get(j++);

        while(i<list1.size() || j<list2.size()) {
            Interval cur;
            if(i>=list1.size()) {
                cur = list2.get(j++);
            } else if(j>=list2.size()) {
                cur = list1.get(i++);
            } else {
                cur = list1.get(i).start<=list2.get(j).start? list1.get(i++): list2.get(j++);
            }

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
