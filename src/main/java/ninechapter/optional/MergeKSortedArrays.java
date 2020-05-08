package ninechapter.optional;

import java.util.*;

public class MergeKSortedArrays {
    class Position {
        public int row;
        public int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    class PositionComparator implements Comparator<Position> {
        int[][] arrays;

        public PositionComparator(int[][] arrays) {
            this.arrays = arrays;
        }

        @Override
        public int compare(Position p1, Position p2) {
            return arrays[p1.row][p1.col] - arrays[p2.row][p2.col];
        }

    }

    public int[] mergekSortedArrays(int[][] arrays) {
        List<Integer> ans = new ArrayList<>();
        if(arrays==null || arrays.length==0) {
            return new int[]{};
        }

        PriorityQueue<Position> pq = new PriorityQueue<>(new PositionComparator(arrays));

        for(int i=0; i<arrays.length; i++) {
            if(arrays[i]==null || arrays[i].length==0) {
                continue;
            }

            pq.offer(new Position(i, 0));
        }

        while(!pq.isEmpty()) {
            Position cur = pq.poll();

            ans.add(arrays[cur.row][cur.col]);

            if(cur.col+1<arrays[cur.row].length) {
                cur.col+=1;
                pq.offer(cur);
            }
        }

        int[] res = new int[ans.size()];

        for(int i=0; i<ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}
