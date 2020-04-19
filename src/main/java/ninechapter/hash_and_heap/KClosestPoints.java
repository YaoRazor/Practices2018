package ninechapter.hash_and_heap;;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {

    class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
    }

    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(new PointComparator(origin));
        for(Point point: points) {
            pq.offer(point);
            if(pq.size()>k) {
                pq.poll();
            }
        }

        Point[] ret = new Point[k];
        while (!pq.isEmpty())
            ret[--k] = pq.poll();
        return ret;
        // write your code here
    }


    class PointComparator implements Comparator<Point> {

        private Point o;

        public PointComparator(Point origin) {
            this.o = origin;
        }

        @Override
        public int compare(Point p1, Point p2) {
            if( Math.pow(p2.x-o.x, 2) + Math.pow(p2.y-o.y, 2)-Math.pow(p1.x-o.x, 2) - Math.pow(p1.y-o.y, 2) ==0) {

                if(p1.x==p2.x) {
                    return p2.y-p1.y;
                } else {
                    return p2.x-p1.x;
                }


            } else {
                return (int)(Math.pow(p2.x-o.x, 2) + Math.pow(p2.y-o.y, 2)-Math.pow(p1.x-o.x, 2) - Math.pow(p1.y-o.y, 2));
            }
        }
    }


}
