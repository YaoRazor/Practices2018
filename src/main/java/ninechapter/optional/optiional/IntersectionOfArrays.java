package ninechapter.optional.optiional;

import java.util.*;

public class IntersectionOfArrays {
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


    public int intersectionOfArrays(int[][] arrs) {
        if(arrs==null || arrs.length==0) {
            return 0;
        }

        PriorityQueue<Position> pq = new PriorityQueue<>(new PositionComparator(arrs));

        for(int i=0; i<arrs.length; i++) {
            if(arrs[i].length==0) {
                continue;
            }
            Arrays.sort(arrs[i]);

            pq.offer(new Position(i, 0));
        }

        if(pq.isEmpty()) {
            return 0;
        }

        Position first = pq.peek();
        int pre = arrs[first.row][first.col]+1;
        int cnt = 1;
        int ans = 0;

        while(!pq.isEmpty()) {
            Position cur = pq.poll();
            int curVal = arrs[cur.row][cur.col];

            if(cur.col+1< arrs[cur.row].length) {
                cur.col+=1;
                pq.offer(cur);
            }

            if(pre==curVal) {
                cnt++;

                if(cnt==arrs.length) {
                    ans++;
                }
            } else {
                cnt = 1;
            }
            System.out.println("cnt is "+cnt+" cur is "+curVal+" pre is "+pre);
            pre = curVal;
        }

        return ans;
    }
}
