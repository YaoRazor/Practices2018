package array;


import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<int[]>();
        int start = newInterval[0];
        int end = newInterval[1];
        int i = 0;

        while(i<intervals.length && intervals[i][1]<start) {
            ans.add(intervals[i]);
            i++;
        }

        while(i<intervals.length && intervals[i][0]<=end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }

        ans.add(new int[]{start, end});

        while(i<intervals.length){
            ans.add(intervals[i]);
            i++;
        }


        return ans.toArray(int[][]::new);
    }
}


