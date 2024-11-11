import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) {
            return intervals;
        }

        Arrays.sort(intervals, (i1, i2)-> {return i1[0]-i2[0];});
        List<int[]> ans = new ArrayList<>();
        int[] pre = intervals[0];

        for(int i=1; i<intervals.length; i++) {
            int[] cur = intervals[i];

            // overlap with pre value exists
            if(cur[0]<=pre[1]) {
                pre[1] = Math.max(pre[1], cur[1]);
            } else {
                ans.add(pre);
                pre = cur;
            }
        }

        ans.add(pre);
        return ans.toArray(int[][]::new);
    }

}






