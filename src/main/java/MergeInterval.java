import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length<2) {
            return intervals;
        }

        Arrays.sort(intervals, (i1, i2)-> i1[0]-i2[0]);

        List<int[]> ans = new ArrayList<>();
        int[] pre = intervals[0];

        for(int i=1; i<intervals.length; i++) {
            int[] cur = intervals[i];
            if(cur[0]>pre[1]) {
                ans.add(pre);
                pre = cur;
            } else {
                pre[1] = Math.max(pre[1], cur[1]);
            }
        }

        ans.add(pre);

        int[][] ret = new int[ans.size()][2];
        for(int i=0; i<ret.length; i++) {
            ret[i] = ans.get(i);
        }

        return ret;
    }

}






