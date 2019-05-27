import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class MergeInterval {

    public int[][] merge(int[][] intervals) {

        if(intervals==null || intervals.length==0) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> ans = new ArrayList<>();

        int curStart = intervals[0][0];
        int curEnd = intervals[0][1];

        for(int i=1; i<intervals.length; i++) {

            int[] cur = intervals[i];

            if(cur[0]<=curEnd) {
                curEnd = Math.max(curEnd, cur[1]);
            } else {
                ans.add(new int[]{curStart, curEnd});
                curStart = cur[0];
                curEnd = cur[1];
            }

        }

        ans.add(new int[]{curStart, curEnd});

        int[][] arr = new int[ans.size()][2];

        // ArrayList to Array Conversion
        for (int i =0; i < ans.size(); i++)  {
            arr[i] = ans.get(i);
        }

        return arr;
    }


}






